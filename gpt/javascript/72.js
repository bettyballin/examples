
// Using node-forge as an example
const forge = require('node-forge');

// Convert your public key to a forge-compatible format
// Assuming publicKey is your RSA public key in PEM format
const publicKey = forge.pki.publicKeyFromPem(yourPublicKeyPem);

// Encrypt your string
const encrypted = publicKey.encrypt(yourString, 'RSA-OAEP');

// Encode the encrypted data to base64
