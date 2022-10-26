const { validationResult } = require('express-validator');
const mongoose = require('mongoose');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');
const { uuid } = require('uuidv4');

const HttpError = require('../models/http-error');
const Station = require('../schemas/station-schema');
const config = require('../config.json');

const authenticateStation = async ({ stationName, password }) => {
    let station = null;
    try{
        station = await Station.findOne({ stationName: stationName });
      } catch(err) {
        const error = new HttpError(
          'Something went wrong, could not find station.',
          500
        );
        return error;
      }

      const match = await bcrypt.compare(password, station.password);
      if(match) {
        const token = jwt.sign({ sub: station.id }, config.secret);
        const { password, ...userWithoutPassword } = station;
        return {
            ...userWithoutPassword,
            token
        };
      } else {
        return res.json({success: false, message: 'passwords do not match'});
      }

}

const saveStation = async (req, res, next) => {
    console.log('Adding the station');
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        console.log(errors);
        return next(new HttpError('Invalid inputs! Please check again.', 422));
    }

    const { 
        stationid,  
        stationName,
        password,
        province,
        district,
        town,
        diesel,
        dieselArrivedTime,
        dieselFinishedTime,
        dieselQuantity,
        petrol,
        petrolArrivedTime,
        petrolFinishedTime,
        petrolQuantity
     } = req.body;

    let existingStation;
    try{
      existingStation = await Station.findOne({ stationName: stationName});
    } catch(err) {
      const error = new HttpError(
        'Something went wrong, could not sign up.',
        500
      );
      return next(error);
    }

    if(existingStation) {
        const error = new HttpError(
          'Station already exists, please sign in.',
          422
        );
        return next(error);
      }

    const hashedPassword = await bcrypt.hash(password, 10);
    console.log(hashedPassword);
    const newStation = new Station({
        stationid: uuid(),  
        stationName,
        password,
        province,
        district,
        town,
        diesel,
        dieselArrivedTime,
        dieselFinishedTime,
        dieselQuantity,
        petrol,
        petrolArrivedTime,
        petrolFinishedTime,
        petrolQuantity
    });

    try {
        const session = await mongoose.startSession();
        session.startTransaction();
        await newStation.save({ session: session });
        await session.commitTransaction();
    } catch (err) {
        const error = new HttpError(
            'Error occured while saving details. Please try again.',
            500
        );
        return next(error);
    }

    res.status(201).json({ Station: saveStation });
};

exports.authenticateStation = authenticateStation;
exports.saveStation = saveStation;