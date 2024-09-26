const crypto = require('crypto');
const fs = require('fs');

// Read DER format CA Certificate
let derCACertificate = fs.readFileSync('./ca_certificate.der', 'binary');

// Convert to PEM
let pemCAKey = `-----BEGIN CERTIFICATE-----\
${Buffer.from(derCACertificate, 'binary').toString('base64')}\
-----END CERTIFICATE-----`;

console.log(pemCAKey);