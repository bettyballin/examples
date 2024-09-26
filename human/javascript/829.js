const crypto = require('crypto');

const password = 'password';
const key = crypto.scryptSync(password, 'salt', 32);

const iv = crypto.randomBytes(16);
const cipher = crypto.createCipheriv('aes-256-gcm', key, iv);
var encrypted = cipher.update("Hello", 'utf8', 'hex') + cipher.final('hex');

console.log(encrypted);