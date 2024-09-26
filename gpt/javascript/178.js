
var CryptoJS = require("crypto-js");

// Encrypt
var secretKey = "your-secret-key";
var plaintext = "my-password";
var encrypted = CryptoJS.AES.encrypt(plaintext, secretKey);
console.log('encrypted:', encrypted.toString());

// Decrypt
var decrypted = CryptoJS.AES.decrypt(encrypted, secretKey);
var originalText = decrypted.toString(CryptoJS.enc.Utf8);
console.log('decrypted:', originalText);

