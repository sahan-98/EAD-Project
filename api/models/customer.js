const mongoose = require('mongoose');

const UserSchema = new mongoose.Schema({
    arrivalTimeQ : {
        type: String,
        required: true
    },

    departTimeQ : {
        type: String,
        required: true
    },

    requestedLitres: {
        type: String,
        required: true
    },

});
//export module
module.exports = mongoose.model('fuel', UserSchema);