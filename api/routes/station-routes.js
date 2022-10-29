const express = require('express');
const router = express.Router();

const { saveStation, authenticateStation,getAllStationsByLocation,getStationByID,updateFuelQuantity } = require('../controllers/station-controller');

router.post('/auth', [], authenticateStation);
router.post('/signup', [], saveStation);
router.get('/:district/:city',[], getAllStationsByLocation);
router.get('/:id',[], getStationByID);
router.put('/updateFuelQuantity', [], updateFuelQuantity);

module.exports = router;