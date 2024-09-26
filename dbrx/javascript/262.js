const elliptic = require('elliptic');
const ec = new elliptic.ec('secp256k1');

// Load the private key from Python.
const privateKeyBase64 = 'your_base64_encoded_private_key_here'; 

// Decode and import the private key into JavaScript.
const privateKeyPem = Buffer.from(privateKeyBase64, 'base64').toString();
const privateKeyJs = ec.keyFromPrivate(privateKeyPem);

// Generate a payload to sign (e.g JSON object).
const dataToSign = { foo: 'bar' };

// Sign the payload using ECDSA with SHA256 hash function.
const signature = privateKeyJs.sign(JSON.stringify(dataToSign), 'sha256');

console.log('Signature: ', {
  r: signature.r.toString(16),
  s: signature.s.toString(16)
});