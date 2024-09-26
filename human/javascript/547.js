const crypto = require('crypto');

const clientPrivateKey = 'your_client_private_key_here';
const data = 'your_data_here';

// Generate a random key
const dynamicallyGeneratedKey = crypto.randomBytes(32);

// Encrypt data with dynamically generated key
const iv = crypto.randomBytes(16);
const cipher = crypto.createCipheriv('aes-256-cbc', dynamicallyGeneratedKey, iv);
let encryptedData = cipher.update(data, 'utf8', 'hex');
encryptedData += cipher.final('hex');

// Encrypt dynamically generated key with client private key
const encryptedKey = crypto.privateEncrypt(
  {
    key: clientPrivateKey,
    padding: crypto.constants.RSA_PKCS1_PADDING,
  },
  dynamicallyGeneratedKey
);

const executableCode = {
  data: encryptedData,
  key: encryptedKey.toString('hex'),
};

console.log(executableCode);