const crypto = require('crypto');

const plaintext = 'Hello World';

// Create a new AES-GCM context
const iv = crypto.randomBytes(12);
const key = crypto.randomBytes(32);
const context = crypto.createCipheriv('aes-256-gcm', key, iv);

// Encrypt the plaintext
let ciphertext = Buffer.concat([context.update(plaintext, 'utf8'), context.final()]);

console.log('Encrypted:', ciphertext.toString('hex'));

// Decrypt the ciphertext
const decipher = crypto.createDecipheriv('aes-256-gcm', key, iv);
const decrypted = decipher.update(ciphertext) + decipher.final('utf8');

console.log('Decrypted:', decrypted);