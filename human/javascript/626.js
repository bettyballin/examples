var CryptoJS = require("crypto-js");

var secretAccessKeyBase64 = "secret";
var hash = CryptoJS.HmacSHA256("Message", secretAccessKeyBase64);
var hashInBase64 = CryptoJS.enc.Base64.stringify(hash);
console.log(hashInBase64);