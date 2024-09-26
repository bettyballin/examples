
const CryptoJS = require("crypto-js");

function encrypt(number, key) {
  return CryptoJS.AES.encrypt(number.toString(), key).toString();
}

function decrypt(ciphertext, key) {
  const bytes = CryptoJS.AES.decrypt(ciphertext, key);
  return bytes.toString(CryptoJS.enc.Utf8);
}

// Usage
const key = "secret_pass";
const number = 10;

const encrypted = encrypt(number, key);
const decrypted = decrypt(encrypted, key);

console.log(encrypted);  // Output: encrypted text (cipher)
console.log(decrypted);  // Output: "10"

