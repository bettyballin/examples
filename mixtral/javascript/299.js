const nacl = require('tweetnacl');

// Generate a new key pair
let keypair = nacl.sign.keyPair();

// Your message
let message = "This is my unencrypted message";

// Convert the message to an ArrayBuffer
let msgUint8Array = new TextEncoder().encode(message);

// Sign the message with your secret key
let signedMessage = nacl.sign(msgUint8Array, keypair.secretKey);

// Verify and open (decrypt) the signature using public key
let decryptedMsg = nacl.sign.open(signedMessage, keypair.publicKey);

if (!decryptedMsg) {
  console.log("Invalid Signature");
} else {
  // Convert back to string
  let decodedString = new TextDecoder().decode(new Uint8Array(decryptedMsg));

  console.log('Decrypted message:', decodedString);
}