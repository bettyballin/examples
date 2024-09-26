var CryptoJS = require("crypto-js");

var encrypted = CryptoJS.enc.Base64.parse("SGVsbG8gd29ybGQh"); // replace with your encrypted data
var cipher = CryptoJS.lib.CipherParams.create({
  ciphertext: CryptoJS.pad.addPadding(encrypted, 144)
});

console.log(cipher);