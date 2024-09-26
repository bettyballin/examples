const crypto = require('crypto');

const publicKey = 'your_public_key_here'; // replace with your public key
const plaintextByte = Buffer.from('your_plaintext_here', 'utf8'); // replace with your plaintext

const encryptCipher = crypto.createCipheriv('RSA-OAEP', {
  key: publicKey,
  oaepHash: 'sha256',
  mgf1Hash: 'sha256',
});

const ciphertextByte = Buffer.concat([encryptCipher.update(plaintextByte), encryptCipher.final()]);

console.log(ciphertextByte.toString('hex'));