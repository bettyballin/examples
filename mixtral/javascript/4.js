const crypto = require('crypto');

// Initialize data and cipher
const data = 'Hello, World!';
const algorithm = 'aes-256-gcm';
const key = crypto.randomBytes(32);
const iv = crypto.randomBytes(16);
const cipher = crypto.createCipheriv(algorithm, key, iv);
const decipher = crypto.createDecipheriv(algorithm, key, iv);

// Encrypt data
const encryptedData = Buffer.concat([
  cipher.update(data),
  cipher.final()
]);

var tag = cipher.getAuthTag();

// Send both `encryptedData` and `tag` to the receiver

// Simulate receiving encrypted data and tag
const receivedEncryptedData = encryptedData;
const receivedTag = tag;

// On decryption side
const encryptedDataWithTag = Buffer.concat([
  receivedTag,
  receivedEncryptedData
]);

decipher.setAuthTag(receivedTag);

var decryptResult = Buffer.concat([
  decipher.update(receivedEncryptedData),
  decipher.final()
]);

console.log(decryptResult.toString()); // Output: Hello, World!