const crypto = require('crypto');
const fs = require('fs');

// Read DER format certificate
let derCertificate = fs.readFileSync('./certificate.der', 'binary');

// Convert to PEM
let pemCertificate = `-----BEGIN CERTIFICATE-----\n${Buffer.from(derCertificate, 'binary').toString('base64')}\n-----END CERTIFICATE-----`;

// Create a public key from the certificate
const certPublicKey = crypto.createPublicKey({
  format: 'pem',
  type: 'spki',
  key: pemCertificate
});

console.log(certPublicKey);