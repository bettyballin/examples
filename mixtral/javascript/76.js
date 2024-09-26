const CryptoJS = require("crypto-js");

// Encrypt data
var cipher = CryptoJS.AES.encrypt("some plaintext", "password");

// Generate HMAC
var hmac = CryptoJS.HmacSHA256(cipher.toString(), "secret key for authentication").toString();

// Combine both
var encryptedAndAuthenticatedData = cipher.toString() + '.' + hmac;

console.log(encryptedAndAuthenticatedData);