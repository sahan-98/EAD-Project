const { validationResult } = require('express-validator');
const mongoose = require('mongoose');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');
const { uuid } = require('uuidv4');

const HttpError = require('../models/http-error');
const User = require('../schemas/user-schema');
const config = require('../config.json');

const authenticate = async (req, res) => {
  try {
      const { email , password } = req.body;

      const user = await User.findOne({ email: email });
      console.log(user);
      if (!user) {
          res.status(401).json({ message: 'User not found' });
      }else {
          isPasswordMatch = await bcrypt.compare(password, user.password);
          console.log(isPasswordMatch);
          if (isPasswordMatch) {
              const { password, ...userWithoutPassword } = user._doc;
              res.send({ result: "Success", user: userWithoutPassword });
          } else {
              res.send("Password is not correct")
          }
      }
    } catch (error) {
        res.status(400).send("Invalid credentials")
    }
}

const saveUser = async (req, res, next) => {
    console.log('Adding the user');
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        console.log(errors);
        return next(new HttpError('Invalid inputs! Please check again.', 422));
    }

    const { name, email, password, vehicleType, vehicleNumber, fuelType } = req.body;

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
        password : hashedPassword,
        vehicleType,
        vehicleNumber,
        fuelType
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
    // const message = "Please Chech Your Email."
    // await sendEmail(newUser.email, "Verify Email", message);

    res.status(201).json({ User: saveUser });
};

const getUserByID = async (req, res) => {
  const userid = req.params.id;
  console.log(userid)

  User.findOne({ userid })
      .then(data => {
          if (!data) {
              res.status(404).send({ message: "User not found. Check ID: " + userid });
          } else {
              res.status(200).send({ data: data });
          }
      })
      .catch(err => {
          res.status(500).send({ message: "Error retrieving User with ID:" + userid });
      });
}

exports.authenticate = authenticate;
exports.saveUser = saveUser;
exports.getUserByID = getUserByID;