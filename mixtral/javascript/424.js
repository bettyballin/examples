const CryptoJS = require("crypto-js");

const dataText = "Hello, World!";
const key = "mysecretkey1234";

const encrypted = CryptoJS.AES.encrypt(dataText, key, {
  mode: CryptoJS.mode.ECB,
  padding: CryptoJS.pad.Pkcs7
}).ciphertext.toString();

console.log('CryptoJS Encryption Result (Hex): ' + encrypted);