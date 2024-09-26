var CryptoJS = require("crypto-js");

// Encryption
let message = "Message";
let key = '1234567890';

const encryptedData = CryptoJS.AES.encrypt(message, key);
console.log('Encrypted: ' + encryptedData.toString());

// Decryption
var bytes  = CryptoJS.AES.decrypt(encryptedData.toString(), key);
let decryptedMessage = bytes.toString(CryptoJS.enc.Utf8)

console.log("Decrypted: " + decryptedMessage);