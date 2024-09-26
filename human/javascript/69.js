const crypto = require('crypto');

console.log(crypto.createHash('sha512').update(
  Buffer.from("74657374696e67", "hex")
).digest('hex'));