const fs = require('fs');
const forge = require('node-forge');

// Read the binary data from a file (DER encoded)
let derData = new Uint8Array(fs.readFileSync('certificate.der'));

// Convert DER to PEM using node-forge library
let asn1Cert = forge.asn1.fromDer(derData);
let certPem = forge.pki.certificateToPem(asn1Cert);

console.log(certPem);