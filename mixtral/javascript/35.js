const fs = require('fs');
const crypto = require('crypto');
const path = require('path');

function getPublicKeyFromCert(cert) {
  // Assuming cert is a PEM-encoded certificate string
  const certBuffer = Buffer.from(cert, 'utf8');
  const publicKey = crypto.createPublicKey({
    key: certBuffer,
    format: 'pem',
    type: 'spki'
  });
  return publicKey.export({ type: 'spki', format: 'pem' });
}

function verifySignature(message, sig, cert) {
  const publicKey = getPublicKeyFromCert(cert);

  // Verify the message
  const verifier = crypto.createVerify("RSA-SHA256");
  verifier.update(JSON.stringify(message));

  if (!verifier.verify(publicKey, sig, 'hex')) {
    throw new Error('Invalid signature');
  }

  // Verify the certificate
  const certVerifier = crypto.createVerify("RSA-SHA256");
  const caCertPath = path.join(__dirname, 'ca_certificate.pem');
  try {
    fs.accessSync(caCertPath, fs.constants.R_OK);
  } catch (err) {
    throw new Error('CA certificate not found or not readable');
  }

  const caCert = fs.readFileSync(caCertPath, 'utf8');
  certVerifier.update(cert);
  if (!certVerifier.verify(caCert, 'hex')) {
    throw new Error('Invalid certificate');
  }
}

// Example usage
const message = { foo: 'bar' };
const signature = 'your_signature_here'; // Replace with actual signature
const cert = 'your_cert_here'; // Replace with actual certificate

try {
  verifySignature(message, signature, cert);
  console.log('Signature and certificate verified successfully');
} catch (err) {
  console.error(err);
}