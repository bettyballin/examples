const CryptoJS = require("crypto-js");

const encrypted = "your_encrypted_data_here"; // replace with your encrypted data

var cipher = CryptoJS.lib.CipherParams.create({
  ciphertext: CryptoJS.enc.Hex.parse(encrypted),
  sigBytes: 144
});