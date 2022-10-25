const mongoose = require('mongoose')

const userSchema = new mongoose.Schema({
    userid: { type: String, required: [true, 'User ID is required'] },  
    name: { type: String, required: [true, 'Username is required'] },
    email: { type: String, required: [true, 'E-mail is required'] },
    password: { type: String, required: [true, 'Passowrd is required'] },
    vehicleType: { type: String, required: [true, 'Vehicle Type is required'] },
    vehicleNumber: { type: String, required: [true, 'Vehicle Number is required'] },
    engineCapacity: {type: String, required: [true, 'Engine Capacity is required']},
    registeredDate: {type: String, required: [true, 'Registered Date is required']}
})

module.exports =  mongoose.model('User', userSchema);
