const express = require('express');
const app = express();


app.get('/home', function(req, res){
    res.send('Home Screen');
});

app.listen(3000, () => console.log('Listening on Port 3000'));