// Node Package
const crypto = require('crypto');

function encryptNode(text) {
  const iv = Buffer.from('0123456789abcdef', 'hex');
  const cipher = crypto.createCipheriv('aes-256-cbc', 'devOps', iv);

  return cipher.update(Buffer.from(JSON.stringify(text), 'utf8')) + cipher.final('hex');
}

console.log(encryptNode("Hello, World!"));

// Browser Package
const CryptoJS = require("crypto-js");

function encryptBrowser(text) {
  const key = CryptoJS.enc.Utf8.parse("devOps");
  const iv = CryptoJS.lib.WordArray.create([0x12345678, 0xfedcba98]);

  return CryptoJS.AES.encrypt(JSON.stringify(text), key, {
    mode: CryptoJS.mode.CBC,
    iv: iv
  }).toString();
}

console.log(encryptBrowser("Hello, World!"));