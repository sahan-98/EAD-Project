const { validationResult } = require('express-validator');
const mongoose = require('mongoose');
const HttpError = require('../helpers/http.error');
const Time = require('../schemas/userstation-schema');

const getWaitingTime = async (req, res) => {
    const shedId = req.params.shedId;
    Time.find({ shedId, isInQueue: false }, { arrivalTime: 1, departureTime: 1, _id: 0 })
        .then(timedetails => {
            console.log(timedetails)
            var totalTimeDiffs = 0;
            timedetails.map(time => {
                totalTimeDiffs += (new Date(time.departureTime) - new Date(time.arrivalTime))/1000
            });
            const WaitingTime = totalTimeDiffs / timedetails.length;
            res.status(200).send({ WaitingTime, uom: 'seconds' });
        })
        .catch(err => {
            res.status(500).send({ message: "Error getting details for station with ID:" + stationId + " // " + err });
        });
}

const updateArrivalTime = async (req, res, next) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        console.log(errors);
        return next(new HttpError('Invalid inputs. Please check again.', 422));
    }
    const { userId, stationId } = req.body;
    try {
        const session = await mongoose.startSession();
        session.startTransaction();
        const log = await Time.findOneAndUpdate(
            {
                userId :userId, 
                stationId: stationId
            },
            {
                arrivalTime: Date().toString(),
                departureTime: '',
                isInQueue: true
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

const updateDepartureTime = async (req, res, next) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        console.log(errors);
        return next(new HttpError('Invalid inputs. Please check again.', 422));
    }
    const { userId, stationId } = req.body;
    const timeLog = await Time.findOne({userId :userId, stationId: stationId});
    if(!timeLog) {
        const error = new HttpError(
            'Invalid credentials.',
            404
        );
        return next(error);
    }
    try {
        const session = await mongoose.startSession();
        session.startTransaction();
        const log = await Time.findOneAndUpdate(
            {
                userId: userId,
                stationId: stationId
            },
            {
                departureTime: Date().toString(),
                isInQueue: false
            },
            {
                new: true
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

exports.getAverageWaitingTime = getWaitingTime;
exports.updateArrivalTime = updateArrivalTime;
exports.updateDepartureTime = updateDepartureTime;
