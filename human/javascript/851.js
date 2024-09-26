const CryptoJS = require("crypto-js");
const password = "your_password_here";
var rawSha1Password = Buffer.from(CryptoJS.SHA1(password).toString(CryptoJS.enc.Base64), "base64").toString("utf8");
console.log(rawSha1Password);