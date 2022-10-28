const mongoose = require('mongoose')

const stationSchema = new mongoose.Schema({
    stationid: { type: String, required: [true, 'Station ID is required'] },  
    stationName: { type: String, required: [true, 'Station Name is required'] },
    password: { type: String, required: [true, 'Passowrd is required'] },
    province:{type: String, required: [true, 'Province is required'] },
    district:{type: String, required: [true, 'District is required'] },
    town:{type: String, required: [true, 'Town is required'] },
    diesel:{type: Boolean},
    dieselArrivedTime:{type: String},
    dieselFinishedTime:{type: String},
    dieselQuantity:{type: String },
    petrol:{type: Boolean},
    petrolArrivedTime:{type: String},
    petrolFinishedTime:{type: String},
    petrolQuantity:{type: String },
})

module.exports =  mongoose.model('Station', stationSchema);