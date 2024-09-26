const crypto = require('crypto');

cryptoAESEncrypt = function(inputHexString, keyHexString) {
  const inputBuffer = Buffer.from(inputHexString, 'hex');
  const keyBuffer = Buffer.from(keyHexString, 'hex').slice(0, 16); // AES-128 requires a 16 bytes (32 hex characters) long key

  const cipher = crypto.createCipheriv('aes-128-ecb', keyBuffer, null);

  let encryptedData = '';

  encryptedData += cipher.update(inputBuffer, 'hex');

  // Finalize the encryption and append it to our result
  return (encryptedData + cipher.final('hex')).toUpperCase();
};

const sKey = "1234567890ABCDEF";

const inputHexString = '060123456789ABCD';

console.log(cryptoAESEncrypt(inputHexString, sKey));