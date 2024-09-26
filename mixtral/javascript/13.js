const crypto = require('crypto');

const algorithm = 'aes-256-cbc';

// Generate random initialization vector
let iv = crypto.randomBytes(16);

// Derive key from password using PBKDF2
let salt = crypto.randomBytes(32);

const iterations = 100000;

const length = 32;

const derivedKey = crypto.pbkdf2Sync('password', salt, iterations, length, 'sha512');

// Encrypt data
let cipher = crypto.createCipheriv(algorithm, derivedKey, iv);

let encryptedData = Buffer.concat([cipher.update(Buffer.from('data to be encrypted')), cipher.final()]);

console.log(encryptedData.toString('base64'));