const nacl = require('tweetnacl');

// Generate a key pair for signing
const keyPair = nacl.sign.keyPair();

console.log("Public Key:", keyPair.publicKey.toString('hex'));
console.log("Private Key:", keyPair.secretKey.toString('hex'));