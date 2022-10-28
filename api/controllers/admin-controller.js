const Station_user = require('../schemas/station_user');

const countVehicleType = async (req, res) => {
    const stationId = req.params.id
    const UserStationList = []
    console.log("countVehicleType started")

    Station_user.find({ stationId })
    .then(data => {
      res.status(200).send({ UserStationList: data });
    })
    .catch(error => {
      res.status(500).send({ error: error.message });
    });

    console.log(UserStationList)
    
    
    let totalArivalBycicles = 0;
    let totalArivalOtherVehicles  = 0;
    let totalArivalThreewheels = 0;
    

    UserStationList.map(station => {
       if(station.user.fuelType === 'Petrol') {
            if(station.arrivalStatus === 'true') {
               if(station.user.vehicleType === 'Bycicle') {
                   totalArivalBycicles++;
               }
               else if((station.user.vehicleType === 'Other Vehicle')) {
                   totalArivalOtherVehicles++;
               }
               else if((station.user.vehicleType === 'Threewheel')) {
                   totalArivalThreewheels++;
               }
            }
           
        }
        else if(station.user.fuelType === 'Diesel') {
            if(station.arrivalStatus === 'Arrived') {
               if(station.user.vehicleType === 'Lorry') {
                   totalArivalBycicles++;
               }
               else if((station.user.vehicleType === 'Other Vehicle')) {
                   totalArivalOtherVehicles++;
               }
               else if((station.user.vehicleType === 'Bus')) {
                   totalArivalThreewheels++;
               }
            }
           
        }
        
    });
    
    

    res.status(200).send({ 
        totalArivalBycicles: totalArivalBycicles,
        totalArivalThreewheels: totalArivalThreewheels,
        totalArivalOtherVehicles: totalArivalOtherVehicles,
        totalArivalBycicles: totalArivalBycicles,
        totalArivalOtherVehicles: totalArivalOtherVehicles,
        totalArivalThreewheels: totalArivalThreewheels
    });

    console.log(res.totalArivalOtherVehicles)

} 



module.exports = {
    countVehicleType
};