const crypto = require('crypto');

async function decrypt(encryptedData, key, iv) {
  const decipher = crypto.createDecipheriv('aes-256-cbc', key, iv);
  let decryptedData = decipher.update(encryptedData, 'utf8');
  decryptedData += decipher.final('utf8');
  return decryptedData;
}

// Example usage:
const key = crypto.randomBytes(32);
const iv = crypto.randomBytes(16);
const encryptedData = crypto.createCipheriv('aes-256-cbc', key, iv).update('Hello, World!', 'utf8') + crypto.createCipheriv('aes-256-cbc', key, iv).final();

decrypt(encryptedData, key, iv).then((decrypted) => {
  console.log(decrypted);
});