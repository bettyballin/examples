const CryptoJS = require("crypto-js");

const key = CryptoJS.enc.Utf8.parse('your-key');
const iv  = CryptoJS.lib.WordArray.random(128/8);

// Encryption
var encryptedText = CryptoJS.AES.encrypt("Message", key, { iv: iv });

console.log("Encrypted Text: " + encryptedText.toString());

// Decryption
var decryptedText = CryptoJS.AES.decrypt(encryptedText, key, { iv: iv });

console.log("Decrypted Text: " + decryptedText.toString(CryptoJS.enc.Utf8));