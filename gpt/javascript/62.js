
const express = require('express');
const crypto = require('crypto');
const app = express();

// Add body-parser middleware to parse the raw body
const bodyParser = require('body-parser');
app.use(bodyParser.raw({ type: '*/*' })); // Parses all bodies as a Buffer

app.post('/trialpay', function(req, res) {
    var key = "[MY MERCHANT KEY]";
    var hash = req.header("TrialPay-HMAC-MD5");
    // Use the raw body for hashing
    var data = req.body;

    var crypted = crypto.createHmac("md5", key)
        .update(data)
        .digest("hex");

