const CryptoJS = require('crypto-js');
const dataText = 'Hello, World!';
const encrypted = CryptoJS.AES.encrypt(
  dataText, 
  CryptoJS.enc.Utf8.parse('2C8E29E736CB9514DD93C4D111244990'), 
  {
    mode: CryptoJS.mode.ECB,
    padding: CryptoJS.pad.Pkcs7
  }
).ciphertext.toString(CryptoJS.enc.Hex);
console.log(encrypted);