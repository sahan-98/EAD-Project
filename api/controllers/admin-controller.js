// const Admin = require('../schemas/fstation-schema');

const countVehicleType = async (req, res) => {
    
    let FStationList = null;
    try{
        FStationList = await Admin.find({}, function(err, result) {
            if (err) {
              console.log(err);
            } else {
              
            }
          });
    } catch(err) {
        return err;
    }
    
    let totalArivalBycicles = 0;
    let totalArivalOtherVehicles  = 0;
    let totalArivalThreewheels = 0;
    

    userList.map(station => {
       if(station.fuelType === 'Petrol') {
            if(station.status === 'Arrived') {
               if(user.VType === 'Bycicle') {
                   totalArivalBycicles++;
               }
               else if((user.VType === 'Other Vehicle')) {
                   totalArivalOtherVehicles++;
               }
               else if((user.VType === 'Threewheel')) {
                   totalArivalThreewheels++;
               }
            }
           
        }
        else if(station.fuelType === 'Diesel') {
            if(station.status === 'Arrived') {
               if(user.VType === 'Lorry') {
                   totalArivalBycicles++;
               }
               else if((user.VType === 'Other Vehicle')) {
                   totalArivalOtherVehicles++;
               }
               else if((user.VType === 'Bus')) {
                   totalArivalThreewheels++;
               }
            }
           
        }
        // else if(user.role === 'Workshop Presenter'){
        //     totalroleWorkshopPresenter++;
        //     if(user.document.docStatus === 'Rejected') {
        //         totalRejectedWorkshop++;
        //     }
        //     else if(user.document.docStatus === 'Accepted') {
        //         totalAcceptedWorkshop++;
        //     }
        //     else if(user.document.docStatus === 'Pending') {
        //         totalPendingWorkshop++;
        //     }
        // }
        
    });
    
    

    res.status(200).send({ 
        totalArivalBycicles: totalArivalBycicles,
        totalArivalThreewheels: totalArivalThreewheels,
        totalArivalOtherVehicles: totalArivalOtherVehicles,
        totalArivalBycicles: totalArivalBycicles,
        totalArivalOtherVehicles: totalArivalOtherVehicles,
        totalArivalThreewheels: totalArivalThreewheels
    });

} 