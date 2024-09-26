const crypto = require('crypto');

const SECRET_KEY = 'your_secret_key_here'; // replace with your secret key

function encrypt(text) {
  const iv = Buffer.from(crypto.randomBytes(16));
  let cipher = crypto.createCipheriv('des-cbc', Buffer.from(SECRET_KEY), iv);
  let encrypted = cipher.update(text);
  encrypted = Buffer.concat([encrypted, cipher.final()]);
  return { iv: iv.toString('hex'), data: encrypted.toString('base64') };
}

function decrypt(hash) {
  const decipher = crypto.createDecipheriv('des-cbc', Buffer.from(SECRET_KEY), Buffer.from(hash.iv, 'hex'));
  let decrypted = decipher.update(Buffer.from(hash.data, 'base64'));
  return Buffer.concat([decrypted, decipher.final()]).toString();
}

// example usage
const text = 'Hello, World!';
const encrypted = encrypt(text);
console.log('Encrypted:', encrypted);

const decrypted = decrypt(encrypted);
console.log('Decrypted:', decrypted);