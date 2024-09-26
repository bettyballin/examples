const crypto = require('crypto');
const data = 'your_data_here';
const key = crypto.createHmac('sha256', data).digest();
console.log(key.toString('hex'));