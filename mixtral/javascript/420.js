const cryptojs = require('crypto-js');

let decodeSecret = 'your_secret_key_here';
let buffer = 'your_buffer_here';

let hmacjs = cryptojs.algo.HMAC.create(cryptojs.algo.SHA1, decodeSecret);
hmacjs.update(buffer);
const hmacResultCryptoJS = hmacjs.finalize().toString();
console.log(`crypto-js HMAC: ${hmacResultCryptoJS}`);