const crypto = require('crypto');

function encryptWithAes256(messageToEncrypt, password) {
  // Generate random salt (16 bytes)
  const salt = crypto.randomBytes(16);

  // Derive key using PBKDF2 with HMAC-SHA-512 and a configurable number of iterations
  const pbkdf2Iterations = 100000;
  const derivedKey = crypto.pbkdf2Sync(password, salt, pbkdf2Iterations, 32, 'sha512');

  // Generate random initialization vector (IV) for AES-CBC mode encryption/decryption (16 bytes)
  const iv = crypto.randomBytes(16);

  // Encrypt the message using AES-256-CBC with PKCS7 padding
  const cipher = crypto.createCipheriv('aes-256-cbc', derivedKey, iv);
  let encryptedMessage = cipher.update(messageToEncrypt, 'utf8', 'hex');
  encryptedMessage += cipher.final('hex');

  // Calculate HMAC-SHA-512 of the salt and IV concatenated with the ciphertext
  const hmac = crypto.createHmac('sha512', password);
  hmac.update(salt.toString('hex') + iv.toString('hex'));
  hmac.update(encryptedMessage, 'hex');
  const mac = hmac.digest();

  return {
    encryptedMessage,
    salt: salt.toString('base64'),
    iv: iv.toString('base64'),
    mac: mac.toString('base64')
  };
}

const messageToEncrypt = 'Hello World!';
const password = 'my-secret-password';

console.log(encryptWithAes256(messageToEncrypt, password));