const CryptoJS = require("crypto-js");

var encrypted = CryptoJS.AES.encrypt("Message", "Secret Passphrase");
var decrypted = CryptoJS.AES.decrypt(encrypted, "Secret Passphrase");

console.log(decrypted.toString(CryptoJS.enc.Utf8));