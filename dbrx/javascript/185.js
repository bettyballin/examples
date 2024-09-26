const crypto = require('crypto');

async function decrypt(key, iv, ciphertext) {
  const decipher = crypto.createDecipheriv('aes-256-cbc', Buffer.from(key), iv);
  let decrypted = decipher.update(ciphertext);
  return Buffer.concat([decrypted, decipher.final()]);
}

// Example usage:
const key = 'your_secret_key_here';
const iv = 'your_initialization_vector_here';
const ciphertext = 'your_ciphertext_here';

decrypt(key, iv, ciphertext).then(decrypted => {
  console.log(decrypted.toString());
}).catch(err => {
  console.error(err);
});