const crypto = require('crypto-js');
const fs = require('fs');

// Set password and file path
const password = 'my_secret_password';
const filePath = '/path/to/file.txt';

// Create AES cipher object
const cipher = crypto.createCipher('aes-256-cbc', password);

// Read file data
fs.readFile(filePath, (err, data) => {
  if (err) throw err;

  // Pad the data to ensure proper encryption
  const paddedData = crypto.pad(data, cipher.blockSize);

  // Encrypt the file data in chunks
  let encryptedData = '';
  for (let i = 0; i < paddedData.length; i += cipher.blockSize) {
    const chunk = paddedData.slice(i, i + cipher.blockSize);
    encryptedData += cipher.encrypt(chunk.toString());
  }

  console.log(encryptedData);
});