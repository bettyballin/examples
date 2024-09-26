const crypto = require('crypto');

const randomBytes = crypto.randomBytes(3); 
const hexValue = randomBytes.toString('hex');
const decimalValue = parseInt(hexValue, 16) / Math.pow(256, 3);

console.log(decimalValue);