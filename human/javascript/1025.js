const crypto = require('crypto');

const key = crypto.createHash('sha256').update('redacted12345678').digest('hex');
const iv = Buffer.from('1111111111111111', 'hex');
const cipher = crypto.createCipheriv('aes-256-ctr', Buffer.from(key, 'hex'), iv);

const input = 'hi';
const encrypted = Buffer.concat([cipher.update(input), cipher.final()]);

console.log(encrypted.toString('base64'));