const CryptoJS = require("crypto-js");

var iv = CryptoJS.enc.Hex.parse('0123456789abcdef');

// Encrypt
var encrypted = CryptoJS.AES.encrypt("Message", "Secret Passphrase", {iv: iv});

// Decrypt
var decrypted = CryptoJS.AES.decrypt(encrypted, "Secret Passphrase", {iv: iv});

console.log("Decrypted message: " + decrypted.toString(CryptoJS.enc.Utf8));