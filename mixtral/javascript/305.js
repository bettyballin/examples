var CryptoJS = require("crypto-js");

var password = "your_password"; // replace with your password
var nonce = "your_nonce"; // replace with your nonce
var created = "your_created"; // replace with your created timestamp

var hashedPassword = CryptoJS.SHA1(password).toString();
var hashedPasswordBytes = CryptoJS.enc.Hex.parse(hashedPassword);

var passwordHash = CryptoJS.enc.Base64.stringify(
    CryptoJS.HmacSHA1(nonce + created, hashedPasswordBytes)
);

console.log(passwordHash);