const mongoose = require('mongoose');
const uniqueValidator = require('mongoose-unique-validator');

const vehicleSchema = new mongoose.Schema({
  vehicle_id: { type: String, required: [true, 'Vehicle ID is required'] },
  vehicleNumber: { type: String, required: [true, 'vehicle Number is required'] },
  vehicleType: { type: String, required: [true, 'vehicle type  is required'] },
  engineCapacity: { type: String, required: [true, 'Engine capacity is required'] },
  registredDate:{ type: String, required: [true, 'Registred date is required'] },
  userid: { type: mongoose.Types.ObjectId, required: true, ref: 'User' }
})

vehicleSchema.plugin(uniqueValidator);

module.exports = mongoose.model('Vehicle', vehicleSchema);