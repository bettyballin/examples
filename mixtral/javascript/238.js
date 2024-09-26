const CryptoJS = require("crypto-js");

let key1 = "0123456789abcdef0123456789abcdef";
let key2 = "0123456789abcdef";
let block = "0123456789abcdef0123456789abcdef";

let encrypted = CryptoJS.TripleDES.encrypt(
  CryptoJS.enc.Hex.parse(block),
  CryptoJS.enc.Hex.parse(key1 + key2),
  {
    mode: CryptoJS.mode.ECB,
    padding: CryptoJS.pad.Pkcs7
  }
);

console.log(encrypted.toString());