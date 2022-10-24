const { validationResult } = require('express-validator');
const mongoose = require('mongoose');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');
const { uuid } = require('uuidv4');

const HttpError = require('../models/http-error');
const User = require('../schemas/user-schema');
const config = require('../config.json');

// authenticate
const authenticate = async ({ email, password }) => {
    let user = null;
    try{
        user = await User.findOne({ email: email });
      } catch(err) {
        const error = new HttpError(
          'Something went wrong, could not find user.',
          500
        );
        return error;
      }

      const match = await bcrypt.compare(password, user.password);
      if(match) {
        const token = jwt.sign({ sub: user.id }, config.secret);
        const { password, ...userWithoutPassword } = user;
        return {
            ...userWithoutPassword,
            token
        };
      } else {
        return res.json({success: false, message: 'passwords do not match'});
      }

}

const saveUser = async (req, res, next) => {
    console.log('Adding the user');
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        console.log(errors);
        return next(new HttpError('Invalid inputs! Please check again.', 422));
    }

    const { name, email, password, vehicleType, vehicleNumber, engineCapacity, registeredDate } = req.body;

    let existingUser;
    try{
      existingUser = await User.findOne({ email: email});
    } catch(err) {
      const error = new HttpError(
        'Something went wrong, could not sign up.',
        500
      );
      return next(error);
    }

    let registeredVehicle;
    try{
      registeredVehicle = await User.findOne({ vehicleNumber: vehicleNumber});
    } catch(err) {
      const error = new HttpError(
        'Something went wrong, could not sign up.',
        500
      );
      return next(error);
    }

    if(existingUser) {
        const error = new HttpError(
          'User already exists, please sign in.',
          422
        );
        return next(error);
      }

    if(registeredVehicle) {
        const error = new HttpError(
          'Vehicle already registered, please sign in.',
          422
        );
        return next(error);
      }

    const hashedPassword = await bcrypt.hash(password, 10);
    console.log(hashedPassword);
    const newUser = new User({
        userid: uuid(),
        name,
        email,
        password,
        vehicleType,
        vehicleNumber,
        engineCapacity,
        registeredDate: new Date()
    });

    try {
        const session = await mongoose.startSession();
        session.startTransaction();
        await newUser.save({ session: session });
        await session.commitTransaction();
    } catch (err) {
        const error = new HttpError(
            'Error occured while saving details. Please try again.',
            500
        );
        return next(error);
    }

    res.status(201).json({ User: saveUser });
};

exports.authenticate = authenticate;
exports.saveUser = saveUser;