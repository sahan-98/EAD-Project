const { validationResult } = require('express-validator');
const mongoose = require('mongoose');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');
const { uuid } = require('uuidv4');

const HttpError = require('../models/http-error');
const Station = require('../schemas/station-schema');
const config = require('../config.json');
const User = require('../schemas/user-schema');
const Pump = require('../schemas/station_user');

const saveUserArrival = async (req, res, next) => {
    console.log('Adding the user arrival');

    const {     
    stationid, 
    email
    } = req.body;

    const useremail = req.body.email;
    console.log(useremail)

    const user = await User.findOne({ email: useremail});
    console.log(user)

    //track the time that user joined the queue
    let t = new Date();
    let currentTime = t.getHours() + ":" + t.getMinutes() + ":" + t.getSeconds();


    const newUserArrival = new Pump({
        stationid,  
        arrivalStatus : true,
        arrivedTime : new Date(),
        departTime : "",
        pumpStatus : false,
        email,
        vehicleType : user.vehicleType ,
        fuelType : user.fuelType
    });

    console.log(newUserArrival);

    try {
        const session = await mongoose.startSession();
        session.startTransaction();
        await newUserArrival.save({ session: session });
        await session.commitTransaction();
    } catch (err) {
        const error = new HttpError(
            'Error occured while saving details. Please try again.',
            500
        );
        return next(error);
    }

    res.status(201).json({ Pump: saveUserArrival });
};

const updateExitafterPump = async (req, res, next) => {

    const { stationid,email } = req.body;
    try {
        const session = await mongoose.startSession();
        session.startTransaction();
        const log = await Pump.findOneAndUpdate(
            {
                stationid: stationid,
                email: email
            },
            {
                departTime: new Date(),
                pumpStatus: true
            },
            {
                new: true,
                upsert: true
            }
        );
        await session.commitTransaction();
        res.status(201).json({ data: log });
    } catch (err) {
        const error = new HttpError(
            'Error occured while logging details. Please try again.',
            500
        );
        return next(error);
    }
    res.send("fail");
};

const updateExitwithoutPump = async (req, res, next) => {

    const { stationid,email } = req.body;
    try {
        const session = await mongoose.startSession();
        session.startTransaction();
        const log = await Pump.findOneAndUpdate(
            {
                stationid: stationid,
                email: email
            },
            {
                departTime: new Date()
            },
            {
                new: true,
                upsert: true
            }
        );
        await session.commitTransaction();
        res.status(201).json({ data: log });
    } catch (err) {
        const error = new HttpError(
            'Error occured while logging details. Please try again.',
            500
        );
        return next(error);
    }
    res.send("fail");
};

exports.saveUserArrival = saveUserArrival;
exports.updateExitafterPump = updateExitafterPump;
exports.updateExitwithoutPump = updateExitwithoutPump;