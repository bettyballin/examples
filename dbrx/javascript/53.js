const CryptoJS = require('crypto-js');

// Your secret key and message as strings.
const secretKey = 'secret';
const message = 'test';

// Compute the HMAC-SHA256 digest of your message using your secret key.
const hmacDigest = CryptoJS.HmacSHA256(message, secretKey);

// Convert the computed digest into its hexadecimal representation.
const hexRepresentation = hmacDigest.toString(CryptoJS.enc.Hex);

console.log(hexRepresentation);