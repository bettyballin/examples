const nacl = require('tweetnacl');
const crypto = require('crypto');

// Generate a random 24-byte nonce
const Rnonc = crypto.randomBytes(24);

// Generate a valid message (Uint8Array)
const data = new Uint8Array(Buffer.from('Hello, World!'));

// Generate a secret key (should be 32 bytes long)
const key = crypto.randomBytes(32);

// Encrypt the data
const encryptedData = nacl.secretbox(data, Rnonc, key);

console.log(encryptedData);