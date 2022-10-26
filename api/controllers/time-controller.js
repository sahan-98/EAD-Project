const mongoose = require('mongoose');
const HttpError = require('../helpers/http.error');
const userStation = require('../schemas/station_user');

const getAvgWaitingTime = async (req, res) =>{
    const stationId = req.params.stationId;
    userStation.find({ stationId, arrivalStatus: false}, {arrivalTime: 1, depatTime: 1, _id: 0})
    .then(tDetails => {
        var TotalTimeDiffs = 0;
        tDetails.map(time => {
            TotalTimeDiffs += (new Date(time.departTime) - new Date(time.arrivedTime))/1000
        });
        const avgTime = TotalTimeDiffs / tDetails.length;
        res.status(200).send({ avgTime, uom: 'seconds'});
    })
    .catch(err =>{
        res.status(500).send({ message: "Error getting details for shed with ID:" + stationId + " // " + err });
    })
}

exports.getAvgWaitingTime = getAvgWaitingTime;