
const crypto = require('crypto');

const secret = 'shezhuansauce';
const key = crypto.createHash('sha256').update(String(secret)).digest();

var tobeEncrypted = 'some secret string';
const iv = crypto.randomBytes(16); // Use the binary data directly for IV

// No need to convert the key to base64 for encryption, use the binary hash directly.
const cipher = crypto.createCipheriv('aes-256-ctr', key, iv);
const encrypted = cipher.update(tobeEncrypted, 'utf8', 'hex') + cipher.final
