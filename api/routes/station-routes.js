const express = require('express');
const router = express.Router();

const { saveStation, authenticateStation } = require('../controllers/station-controller');

const auth = (req, res, next) => {
    authenticateStation(req.body)
        .then(user => user ? res.json(user) : res.status(400).json({ message: 'E-mail or password is incorrect' }))
        .catch(err => next(err));
}

router.post('/auth', [], auth);
router.post('/signup', [], saveStation);

module.exports = router;