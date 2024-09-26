const crypto = require('crypto');

const key = crypto.randomBytes(32); // 256-bit key
const iv = crypto.randomBytes(12); // 96-bit IV

var ciper = crypto.createCipheriv("id-aes-256-GCM", key, iv);
ciper.setAAD(Buffer.from(''));

const data = Buffer.from('Hello, World!');
const encryptedData = Buffer.concat([
  ciper.update(data),
  ciper.final()
]);

var tag = ciper.getAuthTag();

// Decryption

var decipher = crypto.createDecipheriv("id-aes-256-GCM", key, iv);
decipher.setAAD(Buffer.from(''));

const encryptedDataWithTag = Buffer.concat([
  encryptedData,
  tag
]);

var decryptResult = Buffer.concat([
  decipher.update(encryptedDataWithTag),
  decipher.final()
]);

console.log(decryptResult.toString());