
const crypto = require('crypto');

const password = 'password';
// Change the size from 24 to 32 bytes (256 bits)
const key = crypto.scryptSync(password, 'salt', 32);

const iv = crypto.randomBytes(16);
const cipher = crypto.createCipheriv('aes-256-gcm', key, iv);
var encrypted = cipher.update("Hello", 'utf8', 'hex');
encrypted += cipher.final('hex');

const authTag = cipher.getAuthTag(); // Don't forget to obtain the auth tag

console.log(encrypted);
console.log(authTag.toString('hex')); // You'll need the auth tag for decryption

