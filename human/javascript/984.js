const crypto = require('crypto');
const secret = 'your_secret_string'; // replace with your secret string

const key = crypto.createHash('sha256').update(String(secret)).digest('base64').slice(0, 16);

console.log(key);