const forge = require('node-forge');
const crypto = window.crypto || window.msCrypto;

// Generate a private key
const keyPair = forge.pki.rsa.generateKeyPair(2048);
const privateKey = keyPair.privateKey;
const privateKeyInfo = forge.pki.wrapPrivateKeyInfo(privateKey, forge.pki.Oids.rsaEncryption);

// Encrypt the private key
const encryptedPrivateKeyInfo = forge.pki.encryptPrivateKeyInfo(
  privateKeyInfo, 'password', {
    algorithm: 'aes256',
  });

console.log(forge.util.encode64(encryptedPrivateKeyInfo.getBytes()));