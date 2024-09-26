const crypto = require('crypto');

function generateRandomString() {
     return (crypto.getRandomValues(new Uint32Array(1))[0] / 4294967295).toString(36).substring(2, 15) + (crypto.getRandomValues(new Uint32Array(1))[0] / 4294967295).toString(36).substring(2, 15);
}

console.log(generateRandomString());