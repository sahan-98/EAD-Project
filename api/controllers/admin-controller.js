const Station_user = require('../schemas/station_user');
const Station = require('../schemas/station-schema');

const countVehicleType = async (req, res) => {
    const stationId = req.params.id

    console.log("ZZZZZ?",stationId)
    var UserStationList = []
    let totalArivalBycicles = 0;
    let totalArivalPOtherVehicles  = 0;
    let totalArivalThreewheels = 0;
    let totalArivalLorries =0;
    let totalArivalBuses =0;
    let totalArivalDOtherVehicles =0;
    console.log("countVehicleType started")

    Station_user.find({ stationid:stationId })
    .then(data => {
        
        UserStationList = data;
        console.log("ZXZXZX>",UserStationList)

        UserStationList.map(station => {
            if(station.user.fuelType === 'Petrol') {
                 if(station.arrivalStatus === true) {
                    if(station.user.vehicleType === 'bicycle') {
                        totalArivalBycicles++;
                    }
                    else if((station.user.vehicleType === 'Other Vehicle')) {
                        totalArivalPOtherVehicles++;
                    }
                    else if((station.user.vehicleType === 'Threewheel')) {
                        totalArivalThreewheels++;
                    }
                 }
                
             }
             else if(station.user.fuelType === 'Diesel') {
                 if(station.arrivalStatus === 'Arrived') {
                    if(station.user.vehicleType === 'Lorry') {
                        totalArivalLorries++;
                    }
                    else if((station.user.vehicleType === 'Other Vehicle')) {
                        totalArivalDOtherVehicles++;
                    }
                    else if((station.user.vehicleType === 'Bus')) {
                         totalArivalBuses++;
                    }
                 }
                
             }
             
         });
         res.status(200).send({ 
            totalArivalBycicles: totalArivalBycicles,
            totalArivalThreewheels: totalArivalThreewheels,
            totalArivalPOtherVehicles: totalArivalPOtherVehicles,
            totalArivalLorries: totalArivalLorries,
            totalArivalDOtherVehicles: totalArivalDOtherVehicles,
            totalArivalBuses: totalArivalBuses
        });
    
    })
    .catch(error => {
      res.status(500).send({ error: error.message });
    });

    console.log(UserStationList)
    
    
    
    

    
    
    

    
    // console.log(res.totalArivalOtherVehicles)

} 

// const getFuelStatus = async (req, res) => {
//     const {stationid, diesel, petrol} = req.body;
//     try{
//         Station.findOne({ stationid }, '')
//     }
// }



module.exports = {
    countVehicleType
};