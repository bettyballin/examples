var CryptoJS = require("crypto-js");

var secret = "9IeVABv94EQBnT6Mn73742kBZOmzFpsM+c62LU9b/h4=";
var nonce = "1518440585425";
var hmac = CryptoJS.algo.HMAC.create(CryptoJS.algo.SHA256, secret);
hmac.update(nonce);
var hash = hmac.finalize();
var signature = hash.toString(CryptoJS.enc.Base64);

console.log(signature); // blI2ILR8MW4ParkT4R1vvVOXF42gJOAVPgEJtZT7Ivo