const mongoose = require('mongoose')

const userStationSchema = new mongoose.Schema({
    stationId: { type: String, required: [true, 'station ID is required'] },  
    arrivalStatus: { type: Boolean, required: [true, 'arrival Status is required'] },
    arrivedTime: { type: String, required: [true, 'arrived Time is required'] },
    departTime: { type: String, required: [true, 'depart Time is required'] },
    pumpStatus: { type: Boolean, required: [true, 'pump Status Type is required'] },
    user: [{ userId: { type: String, required: [true, 'user Id is required'] },
             vehicleType: { type: String, required: [true, 'vehicle Type is required'] },
             fuelType: { type: String, required: [true, 'fuel Type is required'] } }]
})

module.exports =  mongoose.model('user_stations', userStationSchema);