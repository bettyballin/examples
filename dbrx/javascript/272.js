const crypto = require('crypto');
const encryptionKey = crypto.randomBytes(16);
const iv = crypto.randomBytes(12);

// Encryption
const cipher = crypto.createCipheriv('aes-128-gcm', encryptionKey, iv);
const encrypted = cipher.update('hello world', 'utf8', 'hex') + cipher.final('hex');
const tag = cipher.getAuthTag().toString('hex');
console.log('Encrypted:', encrypted);
console.log('Tag:', tag);

// Decryption
const decipher = crypto.createDecipheriv('aes-128-gcm', encryptionKey, iv);
decipher.setAuthTag(Buffer.from(tag, 'hex'));
const decrypted = decipher.update(encrypted, 'hex', 'utf8') + decipher.final('utf8');
console.log('Decrypted:', decrypted);