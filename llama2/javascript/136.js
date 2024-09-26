const CryptoJS = require('crypto-js');

// Create SHA-256 hash object
const sha256 = CryptoJS.algo.SHA256.create();

// Set HMAC key
const key = CryptoJS.enc.Hex.parse('0123456789abcdef');
const hmac = CryptoJS.algo.HMAC.create(sha256, key);

// Update hash with message
hmac.update('Hello World!');

// Generate HMAC-SHA256 signature
const signature = hmac.finalize();

console.log(signature.toString(CryptoJS.enc.Hex));