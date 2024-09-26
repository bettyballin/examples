const fs = require('fs');
const crypto = require('crypto');

const writer = fs.createWriteStream("test.pem");
const keyPair = crypto.generateKeyPairSync('rsa', {
  modulusLength: 3072,
  publicKeyEncoding: {
    type: 'spki',
    format: 'pem'
  },
  privateKeyEncoding: {
    type: 'pkcs8',
    format: 'pem'
  }
});

writer.write(keyPair.publicKey);
writer.end();