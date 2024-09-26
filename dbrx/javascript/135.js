const crypto = require('crypto');
const secret = 'shezhuansauce';
const hash = crypto.createHash('sha256').update(String(secret));
console.log(hash.digest().slice(0, 32).toString('base64'));