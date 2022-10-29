const express = require('express');
const router = express.Router();

const { saveStation, authenticateStation,getAllStationsByLocation,getStationByID } = require('../controllers/station-controller');

router.post('/auth', [], authenticateStation);
router.post('/signup', [], saveStation);
router.get('/:district/:city',[], getAllStationsByLocation);
router.get('/:id',[], getStationByID);

module.exports = router;