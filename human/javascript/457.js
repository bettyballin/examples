const forge = require('node-forge');

// Generate a private key and certificate chain for demonstration purposes
const { privateKey, certChain } = generateKeyAndCert();

// Set a password for the P12
const password = 'mysecretpassword';

// Wrap WebCrypto PKCS#8 to forge privateKey
const wrappedPrivateKey = wrapPrivateKey(privateKey);

// Generate a P12 that can be imported by Chrome/Firefox
const p12Asn1 = forge.pkcs12.toPkcs12Asn1(wrappedPrivateKey, certChain, password, { algorithm: '3des' });

// Base64-encode P12
const p12Der = forge.asn1.toDer(p12Asn1).getBytes();
const p12b64 = forge.util.encode64(p12Der);

console.log(p12b64);

// Helper function to generate a private key and certificate chain
function generateKeyAndCert() {
  const keypair = forge.pki.rsa.generateKeyPair(2048);
  const cert = forge.pki.createCertificate();
  cert.subject.getField('CN').value = 'example.com';
  cert.issuer.getField('CN').value = 'example.com';
  cert.publicKey = keypair.publicKey;
  cert.sign(keypair.privateKey);
  return { privateKey: keypair.privateKey, certChain: [cert] };
}

// Helper function to wrap WebCrypto PKCS#8 to forge privateKey
function wrapPrivateKey(privateKey) {
  const forgePrivateKey = forge.pki.privateKeyFromPem(privateKey);
  return forgePrivateKey;
}