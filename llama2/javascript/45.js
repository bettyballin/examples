const crypto = require('crypto');

function encrypt(text, key, iv) {
  const cipher = crypto.createCipheriv('aes-256-cbc', key, iv);
  cipher.setAutoPadding(false);
  let encrypted = cipher.update(text, 'utf8', 'base64');
  encrypted += cipher.final('base64');
  return encrypted;
}

const text = "Hello, World!";
const key = crypto.randomBytes(32);
const iv = crypto.randomBytes(16);

const encryptedText = encrypt(text, key, iv, {
  padding: 'Pkcs7'
});

console.log(encryptedText);