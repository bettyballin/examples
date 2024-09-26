const crypto = require('crypto');

const alice = crypto.createDiffieHellman(2048);
const bob = crypto.createDiffieHellman(2048);

// Generate the DH keys
alice.generateKeys();
bob.generateKeys();

// Extract public key in base64 format
let alicePublicKeyBase64 = alice.getPublicKey().toString('base64');
let bobPublicKeyBase64 = bob.getPublicKey().toString('base64');

console.log(alicePublicKeyBase64);
console.log(bobPublicKeyBase64);