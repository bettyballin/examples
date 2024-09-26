const crypto = require('crypto');

function encrypt(data, key) {
  const iv = key.substring(0, 16);
  const cipher = crypto.createCipheriv('aes-256-cbc', key, iv);
  let encrypted = cipher.update(data, 'utf8', 'base64');
  encrypted += cipher.final('base64');
  return encrypted;
}

function decrypt(data, key) {
  const iv = key.substring(0, 16);
  const decipher = crypto.createDecipheriv('aes-256-cbc', key, iv);
  let decrypted = decipher.update(data, 'base64', 'utf8');
  decrypted += decipher.final('utf8');
  return decrypted;
}

const key = "KFmnMAPzP!g@6Dy5HD?JSgYC9obE&m@m";
const encrypted = encrypt("test", key);
console.log("Encrypted: " + encrypted);
console.log("Decrypted: " + decrypt(encrypted, key));