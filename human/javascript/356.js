const CryptoJS = require("crypto-js");

// Define decrypted
let encrypted = CryptoJS.AES.encrypt("Hello, World!", "secret key");
let decrypted = CryptoJS.AES.decrypt(encrypted, "secret key");

console.log(decrypted.toString()); // Hex encoded
console.log(decrypted.toString(CryptoJS.enc.Hex)); // Hex encoded
console.log(CryptoJS.enc.Hex.stringify(decrypted)); // Hex encoded

console.log(decrypted.toString(CryptoJS.enc.Utf8)); // UTF-8 encoded
console.log(CryptoJS.enc.Utf8.stringify(decrypted)); // UTF-8 encoded

console.log(decrypted.toString(CryptoJS.enc.Base64)); // Base64 encoded
console.log(CryptoJS.enc.Base64.stringify(decrypted)); // Base64 encoded