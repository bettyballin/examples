
const nacl = require('tweetnacl');
nacl.util = require('tweetnacl-util');

// Create a new key pair
let naclPair = nacl.sign.keyPair();

// Convert the message to a Uint8Array
let message = nacl.util.decodeUTF8("This is my unencrypted message");

// Sign the message using the secret key
let signedMessage = nacl.sign(message, naclPair.secretKey);

// To verify and open the signed message, use the public key
let openedMessage = nacl.sign.open(signedMessage, naclPair.publicKey);

// If verification fails, openedMessage will be null
if (openedMessage) {
    // Convert the Uint8Array back to a string
    let originalMessage = nacl.util.encodeUTF8(openedMessage);
    console.log(originalMessage); // This should print the original message
} else {
   
