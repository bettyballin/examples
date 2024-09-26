const crypto = require('crypto');

function EncryptString(key, plainText) {
  const iv = crypto.randomBytes(16);
  const cipher = crypto.createCipheriv('aes-128-cbc', key, iv);
  let encrypted = cipher.update(plainText, 'utf8', 'base64');
  encrypted += cipher.final('base64');
  return Buffer.concat([iv, Buffer.from(encrypted, 'base64')]).toString('base64');
}

console.log(EncryptString("xxxxxxxxxxxxxxxx", "Hello World"));