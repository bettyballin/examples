const crypto = require('crypto');
const assert = require('assert');

const algorithm = 'aes256'; 
const key = 'password';
const text = 'I love kittens';

const cipher = crypto.createCipher(algorithm, key);  
const encrypted = cipher.update(text, 'utf8', 'hex') + cipher.final('hex');
const decipher = crypto.createDecipher(algorithm, key);
const decrypted = decipher.update(encrypted, 'hex', 'utf8') + decipher.final('utf8');

assert.equal(decrypted, text);

console.log("Text: " + text);
console.log("Encrypted: " + encrypted);
console.log("Decrypted: " + decrypted);