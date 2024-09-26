const CryptoJS = require("crypto-js");

// Define encrypted key and iv
var encrypted = "your encrypted key";
var iv = "your initialization vector";

// Decrypt
var bytes  = CryptoJS.AES.decrypt(encrypted, "your secret key", { iv: iv });

console.log('Decrypted: ' + bytes.toString(CryptoJS.enc.Utf8));