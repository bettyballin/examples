const crypto = require('crypto');

const key = crypto.randomBytes(32);
const iv = crypto.randomBytes(16);
const testVector = { plaintext: 'Hello, World!' };

var cipher = crypto.createCipheriv("aes-256-cbc", key, iv);
var crypted = cipher.update(testVector.plaintext, "utf8", "hex");
crypted += cipher.final("hex");
console.log(crypted);