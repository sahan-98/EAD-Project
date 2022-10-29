const express = require('express');
const router = express.Router();

const { saveUser, authenticate, getUserByID } = require('../controllers/user-controller');


router.post('/auth', [], authenticate);
router.post('/signup', [], saveUser);
router.get('/:id', [], getUserByID);

module.exports = router;