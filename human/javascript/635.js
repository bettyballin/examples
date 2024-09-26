That's not JavaScript code, it's a Wikipedia article about OpenSSL command-line elliptic curve operations. However, I'll extract the relevant OpenSSL commands and provide a Node.js equivalent using the `crypto` module:


const crypto = require('crypto');

// Generate a private key
const keypair = crypto.generateKeyPairSync('ec', {
  namedCurve: 'secp256k1',
  publicKeyEncoding: {
    type: 'spki',
    format: 'pem'
  },
  privateKeyEncoding: {
    type: 'pkcs8',
    format: 'pem',
    cipher: null,
    passphrase: null
  }
});
console.log(keypair.privateKey);
console.log(keypair.publicKey);

// Generate a public key from a private key
const privateKey = keypair.privateKey;
const publicKey = crypto.createPublicKey({
  key: privateKey,
  format: 'pem',
  type: 'pkcs8'
});
console.log(publicKey.export({ type: 'spki', format: 'pem' }));

// Encrypt and decrypt data
const data = 'Hello, World!';
const encrypted = crypto.publicEncrypt({
  key: publicKey,
  padding: crypto.constants.RSA_PKCS1_OAEP_PADDING,
  oaepHash: 'sha256'
}, Buffer.from(data));
console.log(encrypted.toString('hex'));

const decrypted = crypto.privateDecrypt({
  key: privateKey,
  padding: crypto.constants.RSA_PKCS1_OAEP_PADDING,
  oaepHash: 'sha256'
}, encrypted);
console.log(decrypted.toString());