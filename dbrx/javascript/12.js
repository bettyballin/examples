// Importing sjcl library
const sjcl = require('sjcl');

// Generating a random key
let key = sjcl.random.randomWords(8);

// Encrypting some data with the generated key
let encryptedData = sjcl.encrypt(key, 'This is my secret message!');

console.log("Encrypted Data: ", encryptedData);

// Decrypting and printing out decrypted data
let decryptedData = sjcl.decrypt(key, encryptedData);
console.log("Decrypted Data: ", decryptedData);