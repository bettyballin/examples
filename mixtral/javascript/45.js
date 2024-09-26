const crypto = require('crypto');

// Generate a new initialization vector
let iv = Buffer.from(crypto.randomBytes(16));

var cipher = crypto.createCipheriv('rc4', 'secret', iv);
var cryptext = cipher.update('hello', 'utf8', 'hex') + cipher.final('hex');

// Store the IV and encrypted data for decryption
let storedData = {
  iv: iv,
  cryptext: cryptext
};

var decipher = crypto.createDecipheriv('rc4', 'secret', storedData.iv);
var data = decipher.update(storedData.cryptext, 'hex', 'utf8') + decipher.final('utf8');

console.log(data); // prints "hello"