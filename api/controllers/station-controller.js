const { validationResult } = require('express-validator');
const mongoose = require('mongoose');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');
const { uuid } = require('uuidv4');

const HttpError = require('../models/http-error');
const Station = require('../schemas/station-schema');
const config = require('../config.json');

const authenticateStation = async ({ stationName, password }) => {
  try {
    const { stationName , password } = req.body;

    const station = await Station.findOne({ stationName: stationName });
    console.log(station);
    if (!station) {
        res.status(401).json({ message: 'Station not found' });
    }else {
        isPasswordMatch = await bcrypt.compare(password, station.password);
        if (isPasswordMatch) {
            const { password, ...userWithoutPassword } = user._doc;
            res.send({ result: "Success", station: userWithoutPassword });
        } else {
            res.send("Password is not correct")
        }
    }
  } catch (error) {
      res.status(400).send("Invalid credentials")
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
        stationName,
        password,
        province,
        district,
        town
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
        password : hashedPassword,
        province,
        district,
        town,
        diesel : false,
        dieselArrivedTime : "",
        dieselFinishedTime : "",
        dieselQuantity : "",
        petrol : false,
        petrolArrivedTime : "",
        petrolFinishedTime : "",
        petrolQuantity : ""
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

const getAllStationsByLocation = async (req, res) => {
  const district = req.params.district;
  const city = req.params.city;

  console.log(district)
  console.log(city)

  await Station.find({
    district: new RegExp('\\b' + district + '\\b', 'i'),
    city: new RegExp('\\b' + city + '\\b', 'i')
  })
    .then(data => {
      res.status(200).send({ data: data});
    })
    .catch(err => {
      res.status(500).send({ message: "Error retrieving fuel station with district " + district + " & city " + city });
  });
}


const getStationByID = async (req, res) => {
  const stationid = req.params.id;

  Station.findOne({ stationid })
      .then(data => {
          if (!data) {
              res.status(404).send({ message: "Fuel station not found. Check ID: " + stationid });
          } else {
              res.status(200).send({ data: data });
          }
      })
      .catch(err => {
          res.status(500).send({ message: "Error retrieving fuel station with ID:" + stationid });
      });
}

exports.authenticateStation = authenticateStation;
exports.saveStation = saveStation;
exports.getAllStationsByLocation = getAllStationsByLocation;
exports.getStationByID = getStationByID;