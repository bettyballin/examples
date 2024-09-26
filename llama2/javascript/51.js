const crypto = require('crypto');
const keyLength = 32;
const ivLength = 16;

const symKey = crypto.randomBytes(keyLength);
const iv = crypto.randomBytes(ivLength);

console.log(symKey);
console.log(iv);