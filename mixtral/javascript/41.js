// Import the forge library
const forge = require('node-forge');

// Generate a key pair
const keyPair = forge.pki.rsa.generateKeyPair({bits: 2048, e: 0x10001});

// Serialize
var publicKeyPem = forge.pki.publicKeyToPem(keyPair.publicKey);
var privateKeyPem = forge.pki.privateKeyToPem(keyPair.privateKey);

// Deserialize
var reconstructedPublicKey = forge.pki.publicKeyFromPem(publicKeyPem);
var reconstructedPrivateKey = forge.pki.privateKeyFromPem(privateKeyPem);

// Test the reconstructed keys
console.log(forge.pki.publicKeyToPem(reconstructedPublicKey));
console.log(forge.pki.privateKeyToPem(reconstructedPrivateKey));