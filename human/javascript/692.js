const crypto = require('crypto');

// Generate a private key for demonstration purposes
const { privateKey: privKeyPkcs8DER } = crypto.generateKeyPairSync('rsa', {
  modulusLength: 2048,
});

// Create a public key from the private key
var publicKey = crypto.createPublicKey({
  key: privKeyPkcs8DER,
  type: 'pkcs8',
  format: 'der',
});

// Export the public key in X.509 DER format
var publicKeyX509Der = publicKey.export({ type: 'spki', format: 'der' });

console.log(publicKeyX509Der);