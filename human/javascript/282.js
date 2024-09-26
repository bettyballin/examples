const CryptoJS = require("crypto-js");

const cipher = "your_cipher_text"; // replace with your cipher text
const key = "your_key"; // replace with your key
const iv = "your_iv"; // replace with your iv

const decrypted = CryptoJS.AES.decrypt(cipher, key, { iv: iv });
console.log(decrypted.toString(CryptoJS.enc.Utf8));