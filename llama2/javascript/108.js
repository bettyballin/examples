const crypto = require('crypto');

const message = 'Your payment request';
const key = 'your_secret_key';

// Concatenate the key and message
const input = key + message;

// Generate the HMAC hash
const hmac = crypto.createHmac('sha256', key);
hmac.update(input);
const hash = hmac.digest();

// Output the binary hash
console.log(hash.toString('hex'));