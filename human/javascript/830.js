const CryptoJS = require("crypto-js");

var key = CryptoJS.enc.Hex.parse("000102030405060708090a0b0c0d0e0f");
var iv = CryptoJS.enc.Hex.parse("101112131415161718191a1b1c1d1e1f");
var encrypted = CryptoJS.AES.encrypt("Message", key, { iv: iv });

console.log(encrypted.toString());