const crypto = require('crypto');
const { subtle } = crypto.webcrypto;

// Generate a new key pair
subtle.generateKey(
  {
    name: 'RSA-OAEP',
    modulusLength: 2048,
    publicExponent: new Uint8Array([0x01, 0x00, 0x01]),
    hash: 'SHA-256',
  },
  true,
  ['encrypt', 'decrypt']
).then((keyPair) => {
  const publicKey = keyPair.publicKey;

  // Export the public key
  subtle.exportKey(
    'raw',
    publicKey
  ).then((exportedKey) => {
    console.log(exportedKey);
  });
});