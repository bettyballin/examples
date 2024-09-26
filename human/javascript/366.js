const CryptoJS = require("crypto-js");

const encrypted = CryptoJS.AES.encrypt("Message", "Secret Passphrase");
const password = "Secret Passphrase";

var decrypted = CryptoJS.AES.decrypt(encrypted, password);

console.log(decrypted.toString(CryptoJS.enc.Utf8));