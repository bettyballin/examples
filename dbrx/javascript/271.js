const CryptoJS = require("crypto-js");

const payload = "hello";
var iv = CryptoJS.enc.Utf8.parse("1020304050607080");

// Add this line to explicitly use pkcs7 padding
CryptoJS.pad.Pkcs7();

var derived_key = CryptoJS.SHA256("your_secret_password").toString();

var test = CryptoJS.AES.encrypt(
  payload, 
  derived_key, 
  {iv: iv, mode: CryptoJS.mode.CBC}
).toString();

console.log(test);