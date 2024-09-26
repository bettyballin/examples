const cryptojs = require('crypto-js');
const base32 = require('base32-js');

const secret = 'your_secret_string'; // replace with your secret string

const decodeSecret1 = cryptojs.enc.Base64.parse(base32.encode(secret));
const decodeSecret2 = cryptojs.lib.WordArray.create([...secret]);

console.log(decodeSecret1);
console.log(decodeSecret2);