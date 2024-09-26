const dataText = 'Hello';

const crypto = require('crypto');
const ky = Buffer.from('2C8E29E736CB9514DD93C4D111244990', 'hex');
const c = crypto.createCipheriv('aes-128-ecb', ky, null);
const r = c.update(dataText, 'utf-8', 'hex') + c.final('hex');

console.log(r);

const CryptoJS = require('crypto-js');
const key = CryptoJS.enc.Hex.parse('2C8E29E736CB9514DD93C4D111244990');

const encrypted = CryptoJS.AES.encrypt(dataText, key, {
  mode: CryptoJS.mode.ECB,
  padding: CryptoJS.pad.Pkcs7
});
const encryptedHex = encrypted.ciphertext.toString(CryptoJS.enc.Hex);
console.log(encryptedHex);