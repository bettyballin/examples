Here is the executable JavaScript code:


const crypto = require('crypto');

const randValue = Array(4).fill(0).map(() => crypto.randomBytes(4).readUInt32LE(0)).join('');
console.log(randValue);