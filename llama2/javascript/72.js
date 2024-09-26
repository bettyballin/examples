const CryptoJS = require('crypto-js');

// Use AES-GCM with the same settings as AWS KMS
const encryptedData = CryptoJS.AES.encrypt(
  'your plaintext data',
  'your secret key',
  {
    mode: CryptoJS.mode.GCM,
    padding: CryptoJS.pad.NoPadding
  }
);

console.log(encryptedData.toString());