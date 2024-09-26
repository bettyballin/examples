
const fs = require('fs');
const { Certificate } = require('@fidm/x509');

// Read the DER-formatted file
const derCertificate = fs.readFileSync('path/to/certificate.der');

// Convert it to PEM format
const pemCertificate = `-----BEGIN CERTIFICATE-----\n${derCertificate.toString('base64').match(/.{0,64}/g).join('\n')}\n-----END CERTIFICATE-----`;

// Now, you can use the PEM-formatted certificate with the crypto module
console.log(pemCertificate);

// Optionally, you might want to save it to a file
fs.writeFileSync('path/to/certificate.pem', pemCertificate);

