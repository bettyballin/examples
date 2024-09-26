const crypto = require('crypto');
const buffer = Buffer.from('Hello, World!');

console.log(crypto.createHash('sha256').update(buffer).digest("hex"));
console.log(crypto.createHash('sha3-256').update(buffer).digest("hex"));