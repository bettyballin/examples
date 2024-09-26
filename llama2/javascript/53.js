var CryptoJS = require("crypto-js");

var secret = "secret";
var message = "test";

var hmac = CryptoJS.HmacSHA256(message, secret);

console.log(hmac.toString());