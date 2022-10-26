const express = require('express');
const router = express.Router();
const controller = require('../controllers/admin-controller');


router.get('/count', [], controller.countVehicleType);


module.exports = router