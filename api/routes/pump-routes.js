const express = require('express');
const router = express.Router();

const { saveUserArrival,updateExitafterPump,updateExitwithoutPump} = require('../controllers/pump-controller');

router.post('/addArrival', [], saveUserArrival);
router.put('/updatePump', [], updateExitafterPump);
router.put('/updateExit', [], updateExitwithoutPump);

module.exports = router;