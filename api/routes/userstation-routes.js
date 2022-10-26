const express = require('express');
const router = express.Router();

const userstationController = require('../controllers/userstation-controller');

router.get('/times/WaitingTime/:stationdId', userstationController.getWaitingTime);
router.put('/times/arrivals', userstationController.updateArrivalTime);
router.put('/times/departures', userstationController.updateDepartureTime);

module.exports = router;


