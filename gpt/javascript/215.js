
const crypto = require('crypto');
const base64 = require('base64');

// Your encrypted message
const encryptedMessageBase64 = 'SxQE+SERkAzYcdG/ESAhiQ==';

// Convert base64 to binary buffer
const encryptedMessage = Buffer.from(encryptedMessageBase64, 'base64');

// MD5 hashing of the password to match Python's key derivation
const password = 'key';
const md5 = crypto.createHash('md5');
md5.update(password);
const key = md5.digest('hex').slice(0, 16); // Use only the first 16 bytes

