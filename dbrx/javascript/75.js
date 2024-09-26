const { generateKeyPair } = require('crypto');

generateKeyPair('rsa', {
  modulusLength: 2048,
  publicKeyEncoding: {
    type: 'spki',
    format: 'pem'
  },
  privateKeyEncoding: {
    type: 'pkcs1',
    format: 'pem'
  }
}, (err, publicKey, privateKey) => {
  if (err) {
    console.error(err);
  } else {
    console.log('Public Key:');
    console.log(publicKey);
    console.log('Private Key:');
    console.log(privateKey);
  }
});