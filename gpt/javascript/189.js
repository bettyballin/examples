
var crypto = require('crypto');

function encrypt(txt, cryptkey) {
    // Convert the key to a 256-bit key (32 bytes)
    var key = crypto.createHash('sha256').update(String(cryptkey)).digest('base64').substr(0
