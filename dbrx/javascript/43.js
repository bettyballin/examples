var CryptoJS = require("crypto-js");

var plaintext = "some plaintext";
var password = "password";

// Encrypt and authenticate using AES-128-CBC with PKCS#7 padding (default)
var encrypted = CryptoJS.AES.encrypt(plaintext, password);
var ciphertext = encrypted.ciphertext.toString(CryptoJS.enc.Base64);

// Compute HMAC-SHA256 of the concatenation of IV and ciphertext
var hmacKey = CryptoJS.SHA256(password).toString();
var iv = encrypted.iv.toString();
var message = CryptoJS.lib.WordArray.create(iv + ciphertext);
var mac = CryptoJS.HmacSHA256(message, hmacKey);

console.log("Ciphertext:", ciphertext);
console.log("HMAC-SHA256:", mac.toString());