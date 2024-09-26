const crypto = require('crypto');

function encrypt_token(data) {
  const key = 'xNRxA48aNYd33PXaODSu...';

  // Generate a random IV with the correct length
  let iv = Buffer.allocUnsafe(16);

  crypto.randomFillSync(iv);
  const cipher = crypto.createCipheriv('aes-256-cbc', key, iv);

  let encryptedData = Buffer.concat([
    // Prefix the IV to our data
    cipher.update(data),
    // Append the final bytes
    cipher.final()
  ]);

  return {
    content: encryptedData,
    iv: iv.toString('base64')
  };
}

function decrypt_token({ content, iv }) {
  const key = 'xNRxA48aNYd33PXaODSu...';

  // Convert the base64 IV back to a Buffer
  let bufferIv = Buffer.from(iv, 'base64');

  const decipher = crypto.createDecipheriv('aes-256-cbc', key, bufferIv);
  let decryptedData = Buffer.concat([
    decipher.update(content),
    decipher.final()
  ]);

  return decryptedData.toString();
}

// Test the functions
let data = "Hello, World!";
let encrypted = encrypt_token(data);
console.log("Encrypted data: ", encrypted);

let decrypted = decrypt_token(encrypted);
console.log("Decrypted data: ", decrypted);