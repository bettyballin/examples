// export used
var express = require('express');
var url = require("url");
var path = require("path");

const _port = 3000;

var app = express();

app.use(express.static(__dirname + '/../public'));

app.get('/', function (req, res) {
    res.sendFile('index.html');
});

app.listen(_port, function() { 
    console.log(`listening port ${_port} 
    __dirname : ${__dirname}`);
});