
const express = require('express');
const bodyParser = require('body-parser');
const dotenv = require('dotenv');
const app = express();
const path = require('path');
const fs = require('fs');

dotenv.config();

app.use(bodyParser.urlencoded({extended: true}));

// Middleware to block access to .git folders
app.use((req, res, next) => {
    if (req.path.includes('/.git') || fs.existsSync(path.join(__dirname, req.path, '.git'))) {
        return res.status(403).send('Access denied');
    }
    next();
});

// Serving static files but excluding .git
app.use(express.static(__dirname, {
    dotfiles: 'ignore' // ignores files starting with a dot
}));

app.set('view engine', 'ejs');

var environment = process.env.NODE_ENV;
var endpoint = process.env.AUTOMATION_API_ENDPOINT;
var port = process.env.PORT;

console.log('
