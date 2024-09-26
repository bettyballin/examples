
const forge = require('node-forge');

// Assuming requestBase64Url.protected and requestBase64Url.payload are defined and contain your data
const dataToSign = `${requestBase64Url.protected}.${requestBase64Url.payload}`;

// Create a SHA-256 message digest
let md = forge.md.sha256.create();
md.update(dataToSign, 'utf8');

// Load your private key from PEM format
const privateKeyPem = this.keys.accountKey.privatePem;
const privateKey = forge.pki.privateKeyFromPem(privateKeyPem);

// Sign the message digest
const signature = privateKey.sign(md);

// Convert the signature to a Buffer
const signatureBuffer = Buffer.from(signature);

// Convert the signature to base64url format
const signatureBase64Url = signatureBuffer.toString('base64')
  .replace(/\+/g, '-')
  .replace(/\//g, '_')
  .replace(/=/g, '');

console.log
