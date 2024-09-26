
// Import the library
var nacl = require('tweetnacl');
nacl.util = require('tweetnacl-util');

// Generate key pair
var keyPair = nacl.box.keyPair();

// Encrypt the message
var nonce = nacl.randomBytes(nacl.box.nonceLength);
var message = nacl.util.decodeUTF8('Your secret data');
var encrypted = nacl.box(message, nonce, keyPair.publicKey, keyPair.secretKey);

// Save the encrypted data and nonce to localStorage
localStorage.setItem('encrypted', nacl.util.encodeBase64(encrypted));
localStorage.setItem('nonce', nacl.util.encodeBase64(nonce));

