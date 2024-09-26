const crypto = require('crypto');

// Use a more secure random salt
const salt = crypto.randomBytes(64);

// Increase the number of scrypt iterations for better security
const keyLengthInBytes = 32; // AES-256 requires exactly 32 bytes
const N = Math.pow(2, 18);
const r = 8;
const p = 1;

const password = 'password';

// Derive the encryption key
const derivedKey = crypto.scryptSync(
    Buffer.from(password),
    salt,
    keyLengthInBytes,
    { N, r, p, maxmem: 1024 * 1024 * 1024 }
);

console.log('Derived Key:', derivedKey.toString('hex'));