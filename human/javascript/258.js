const crypto = require('crypto'); 
const algorithm = 'aes256'; 
const key = "123456"; 

function encryptString(text) {
  var cipher = crypto.createCipher(algorithm, key);
  return cipher.update(text, 'utf8', 'hex') + cipher.final('hex');
};

function decryptString(text) {
  var decipher =  crypto.createDecipher(algorithm, key);
  return decipher.update(text, 'hex', 'utf8') + decipher.final('utf8');
};

// Test the functions
const originalText = "Hello, World!";
const encryptedText = encryptString(originalText);
console.log("Encrypted Text: ", encryptedText);

const decryptedText = decryptString(encryptedText);
console.log("Decrypted Text: ", decryptedText);