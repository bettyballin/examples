const crypto = require('crypto');

// Generate RSA keypair
const { publicKey, privateKey } = crypto.generateKeyPairSync("rsa", {
  modulusLength: 4096
});

// Convert PKCS#1 to SubjectPublicKeyInfo
let pubPEM = `-----BEGIN PUBLIC KEY-----\n`;
pubPEM += `${publicKey.export({ format: 'pem', type: 'spki' })}\n`
pubPEM += `-----END PUBLIC KEY-----`;

console.log(pubPEM);