const base64url = require('base64url');
const crypto = require('crypto');
const fs = require('fs');

function readKeyPair(path) {
  return {
    publicKey: fs.readFileSync(path.publicPath, 'utf8'),
    privateKey: fs.readFileSync(path.privatePath, 'utf8')
  };
}

function encryptWithPrivateKey(privateKey, message) {
  const bufferMessage = Buffer.from(message, 'utf8');
  return crypto.privateEncrypt(privateKey, bufferMessage);
}

function decryptWithPublicKey(publicKey, buffer) {
  return crypto.publicDecrypt(publicKey, buffer);
}

function hashMessage(message, algorithm) {
  const hash = crypto.createHash(algorithm);
  hash.update(message);
  const hashValue = hash.digest('hex');
  return hashValue;
}

const JWT =
  'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6Ikpv' +
  'aG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c';

const KEY_PAIR_PATH = {
  publicPath: 'rsa_pub.pem',
  privatePath: 'rsa_priv.pem'
};

const jwtParts = JWT.split('.');
const header = base64url.decode(jwtParts[0]);
const payload = base64url.decode(jwtParts[1]);
const signature = base64url.toBuffer(jwtParts[2]);

console.log(header);
console.log(payload);

const keyPair = readKeyPair(KEY_PAIR_PATH);
const decryptedHashValueHex =
  decryptWithPublicKey(keyPair.publicKey, signature).toString('hex');

const newHash = hashMessage(
  jwtParts[0] + '.' + jwtParts[1],
  'SHA256'
).toLowerCase();

console.log();
console.log(decryptedHashValueHex);
console.log();
console.log(newHash);

if (decryptedHashValueHex === newHash) {
  console.log('Signature is valid');
} else {
  console.log('Signature is not valid');
}