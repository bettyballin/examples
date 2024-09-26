const CryptoJS = require("crypto-js");

// assuming result and cryptKey are defined somewhere
var result = {
  data: "your encrypted data",
  iv: "your initialization vector"
};
var cryptKey = "your secret key";

var decrypted = CryptoJS.AES.decrypt(result.data, cryptKey, {
  mode: CryptoJS.mode.CBC,
  iv: result.iv
});

console.log(decrypted.toString(CryptoJS.enc.Utf8));