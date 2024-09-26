That's not JavaScript, it's C#. Here is the JavaScript equivalent:


function encryptString(key, plainText) {
  return CryptoJS.AES.encrypt(plainText, key).toString();
}


However, to make this code executable, you'll need to include the CryptoJS library. Here's the complete executable code:


const CryptoJS = require("crypto-js");

function encryptString(key, plainText) {
  return CryptoJS.AES.encrypt(plainText, key).toString();
}

// Test the function
const key = "mySecretKey";
const plainText = "Hello, World!";
const encryptedText = encryptString(key, plainText);
console.log(encryptedText);