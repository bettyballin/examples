const crypto = require('crypto');
const fs = require('fs');

function openssl_seal(message, publicKey) {
  const encrypted = crypto.publicEncrypt({
    key: publicKey,
    padding: crypto.constants.RSA_PKCS1_PADDING
  }, Buffer.from(message));
  return encrypted.toString('base64');
}

function encrypt(encrypted, privateKey) {
  const cipher = crypto.createCipheriv('aes-256-cbc', privateKey, Buffer.alloc(16, 0));
  const encryptedBuffer = Buffer.from(encrypted, 'base64');
  let envelope = cipher.update(encryptedBuffer);
  envelope = Buffer.concat([envelope, cipher.final()]);
  return envelope.toString('base64');
}

const publicKey = fs.readFileSync('public.key', 'utf8');
const privateKey = fs.readFileSync('private.key', 'utf8');
const message = 'Hello, World!';

const encrypted = openssl_seal(message, publicKey);
const envelope = encrypt(encrypted, privateKey);

console.log(envelope);