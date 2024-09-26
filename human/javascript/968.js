const crypto = require('crypto');

function getSalt() {
    return crypto.randomBytes(32);
}

const saltB64 = getSalt().toString('base64');
console.log(saltB64);