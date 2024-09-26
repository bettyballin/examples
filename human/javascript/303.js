const crypto = require('crypto');
const cipher_seed = 'some_random_characters';

const encrypt = (text) => {
  const cipher = crypto.createCipher('aes-256-cbc', cipher_seed);
  let crypted = cipher.update(text, 'utf8', 'hex');
  crypted += cipher.final('hex');
  return crypted;
};

const decrypt = (text) => {
  const decipher = crypto.createDecipher('aes-256-cbc', cipher_seed);
  let decrypted = decipher.update(text, 'hex', 'utf8');
  decrypted += decipher.final('utf8');
  return decrypted;
};

// Example usage:
const encrypted = encrypt('Hello, World!');
console.log(`Encrypted: ${encrypted}`);

const decrypted = decrypt(encrypted);
console.log(`Decrypted: ${decrypted}`);