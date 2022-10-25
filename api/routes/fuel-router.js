const fuelController = require('../controllers/fuelController');

//fuelRoutes
router.route('/fuel')
    .post(fuelController.addFuels);

//get areas
router.route('/stations/district')
    .get(stationController.getDistrict);
    router.route('/stations/city')
    .get(stationController.getCity);

//get station names by city
router.route('/stations/names/:city')
    .get(stationController.getStationNamesByCity);

//get station by name
router.route('/stations/:name')
    .get(stationController.getStationByName);

//export router
module.exports = router;
