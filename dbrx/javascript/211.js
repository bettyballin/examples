const CryptoJS = require("crypto-js");
const Buffer = require('buffer').Buffer;

var password  = 'SECRETPASSWORD';
var rawSha1Password = Buffer.from(CryptoJS.SHA1(password).toString(), "hex");

console.log(rawSha1Password);