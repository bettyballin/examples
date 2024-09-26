
const CryptoJS = require("crypto-js");

// The secret key for encryption and decryption
const secretKey = "my-secret-key";

// The message you want to encrypt
const message = "Message";

// Encrypting the message
const encrypted = CryptoJS.AES.encrypt(message, secretKey).toString();
console.log("encrypted:", encrypted);

// Decrypting the message
const decryptedBytes = CryptoJS.AES.decrypt(encrypted, secretKey);
const decryptedMessage = decryptedBytes.toString(CryptoJS.enc.Utf8);
console.log("decrypted:", decryptedMessage);

