const crypto = require('crypto');

const c = new Date();
const x = (c.getTime() + "." + c.getMilliseconds()).toString() + ".uIn";
const key = "sevsolut";
const plaintext = x;

const cipher = crypto.createCipher('aes-256-cbc', key);
const decipher = crypto.createDecipher('aes-256-cbc', key);

let encryptedPassword = cipher.update(plaintext, 'utf8', 'base64');
encryptedPassword += cipher.final('base64');

let decryptedPassword = decipher.update(encryptedPassword, 'base64', 'utf8');
decryptedPassword += decipher.final('utf8');

console.log('encrypted :', encryptedPassword);
console.log('decrypted :', decryptedPassword);