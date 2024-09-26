var CryptoJS = require("crypto-js");

var decryptedBytes = CryptoJS.AES.decrypt(JSON.parse(localStorage.getItem('secure_data')), 'secret key 123');
let originalText = decryptedBytes.toString(CryptoJS.enc.Utf8);
console.log("Decryption: " + originalText);