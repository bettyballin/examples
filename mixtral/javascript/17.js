// Import the sjcl library
var sjcl = require("sjcl");

// Encryption
var password = "my_password";
var plaintext = "Hello World!";

var encryptedData = sjcl.encrypt(password, plaintext);

console.log("Encrypted data:", encryptedData);

// Decryption
var decryptedText = sjcl.decrypt(password, encryptedData);

console.log("Decrypted text:", decryptedText);