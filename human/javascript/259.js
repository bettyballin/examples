const crypto = require('crypto');

// Generate a new ECC private key
const { privateKey } = crypto.generateKeyPairSync('ec', {
  namedCurve: 'secp256r1',
  publicKeyEncoding: {
    type: 'spki',
    format: 'der'
  },
  privateKeyEncoding: {
    type: 'pkcs8',
    format: 'der'
  }
});

const key = crypto.createPrivateKey({
  key: privateKey,
  format: 'der',
  type: 'pkcs8'
});

// Import the key
const importedKey = crypto.createPrivateKey({
  key: key.export({
    type: 'pkcs8',
    format: 'der'
  }),
  format: 'der',
  type: 'pkcs8'
});