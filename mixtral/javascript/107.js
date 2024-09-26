const CryptoJS = require('crypto-js');

// Encrypt
let encryptedText = '';

function encrypt(textToEncrypt){
  const salt = CryptoJS.lib.WordArray.random(128/8);

  // Generate a random key
  let secretKey = CryptoJS.PBKDF2('password', salt, {
    hasher: CryptoJS.algo.SHA512,
    iterations: 999
  });

  encryptedText = CryptoJS.AES.encrypt(textToEncrypt, secretKey).toString();

  // Save the salt and iv for decryption
  localStorage.setItem('salt', JSON.stringify(salt));
}

// Decrypt
function decrypt(){

  const savedSalt = CryptoJS.enc.Hex.parse(localStorage.getItem("salt"));

  // Generate the same secret key
  let secretKey = CryptoJS.PBKDF2('password', savedSalt, {
    hasher: CryptoJS.algo.SHA512,
    iterations: 999
  });

  const decryptedText = CryptoJS.AES.decrypt(encryptedText, secretKey).toString(CryptoJS.enc.Utf8);

  return decryptedText;
}

// Test the functions
encrypt('Hello, World!');
console.log('Encrypted Text:', encryptedText);
console.log('Decrypted Text:', decrypt());