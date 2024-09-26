const crypto = require('crypto');

const PRK = 'your_secret_key_here'; // replace with your PRK value
const checkValue = crypto.createHmac('sha256', PRK).update('check value\x01').digest('hex');

console.log(checkValue);