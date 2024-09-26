const CryptoJS = require("crypto-js");

// dummy encrypted object for demonstration
const encrypted = {
  ciphertext: CryptoJS.enc.Hex.parse("your_encrypted_hex_string_here")
};

console.log(CryptoJS.enc.Base64.stringify(encrypted.ciphertext));