// Import CryptoJS library
const CryptoJS = require("crypto-js");

// Encrypt function with password-based key derivation (PBKDF2)
function encryptAES(text, pass) {
  const salt = CryptoJS.lib.WordArray.random(128 / 8);
  const iv = CryptoJS.lib.WordArray.random(16);

  const key = CryptoJS.PBKDF2(pass, salt, {keySize: 256/32, iterations: 1000});
  const encrypted = CryptoJS.AES.encrypt(text, key, {iv: iv});

  return {
    ciphertext: encrypted.ciphertext.toString(CryptoJS.enc.Base64),
    salt: salt.toString(CryptoJS.enc.Hex),
    iv: iv.toString(CryptoJS.enc.Hex)
  };
}

// Decrypt function with password-based key derivation (PBKDF2)
function decryptAES(cipherObj, pass) {
  const salt = CryptoJS.enc.Hex.parse(cipherObj.salt);
  const iv = CryptoJS.enc.Hex.parse(cipherObj.iv);

  const key = CryptoJS.PBKDF2(pass, salt, {keySize: 256/32, iterations: 1000});
  const decrypted = CryptoJS.AES.decrypt({ciphertext: CryptoJS.enc.Base64.parse(cipherObj.ciphertext)}, key, {iv: iv});

  return decrypted.toString(CryptoJS.enc.Utf8);
}

// Encrypt and store in local storage
const encryptedData = encryptAES("Hello World", "mysecretpassword");
localStorage.setItem('encryptedText', JSON.stringify(encryptedData));

// Retrieve from local storage & decrypt
const storedEncryptedData = localStorage.getItem('encryptedText');
if (storedEncryptedData) {
  const decryptedValue = decryptAES(JSON.parse(storedEncryptedData), "mysecretpassword");
  console.log(decryptedValue); // Should print: Hello World
}