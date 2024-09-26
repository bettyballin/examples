const CryptoJS = require("crypto-js");

const key = "xxxxxxxxxxxxxxxx";
const msg = "yM377gXxX5Du71hgkPH+Fg==";

const decrypted = CryptoJS.AES.decrypt(
  msg, 
  CryptoJS.enc.Utf8.parse(key),
  { mode: CryptoJS.mode.ECB }
);

console.log(decrypted.toString(CryptoJS.enc.Utf8));