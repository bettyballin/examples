// Import CryptoJS library
const CryptoJS = require("crypto-js");

// Define variables
var content = "Your content to be encrypted";
var key = "Your secret key";
var yourIV = "Your initialization vector";

// Encrypt Data
var encryptObject = CryptoJS.AES.encrypt(content, key, { iv: yourIV });

// Calculate HMAC
var HMAC = CryptoJS.HmacSHA256(encryptObject.toString(), key);

// Log results
console.log("Encrypted Data: ", encryptObject.toString());
console.log("HMAC: ", HMAC.toString());