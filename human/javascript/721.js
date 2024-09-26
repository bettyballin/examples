const crypto = require('crypto');
const sodium = require('sodium-native');

// Hex decode
const encryptedHex = 'your_encrypted_hex_string';
const encrypted = Buffer.from(encryptedHex, 'hex');

// Decrypt
const nonce = Buffer.from('0123456789abcdefghijvbnm', 'utf8');
const key = Buffer.from('827ccb0eea8a706c4c34a16891f84e7b', 'utf8');
const decrypted = sodium.crypto_secretbox_open(encrypted, nonce, key);

// Convert to JavaScript object
const decryptedJSON = JSON.parse(decrypted.toString('utf8'));

console.log("Zip:            " + decryptedJSON.zip);
console.log("Account number: " + decryptedJSON.account_number);
console.log("Passcode:       " + decryptedJSON.passcode);
console.log("Account type:   " + decryptedJSON.account_type);
console.log("Request:        " + decryptedJSON.request);
console.log("Device:         " + decryptedJSON.device);