'use strict';

const crypto = require('crypto');

const key = Buffer.from('xNRxA48aNYd33PXaODSutRNFyCu4cAe/InKT/Rx+bw0=', 'base64');
const iv = Buffer.from('81dFxOpX7BPG1UpZQPcS6w==', 'base64');

function encrypt_token(data) {
  const cipher = crypto.createCipheriv('aes-256-cbc', key, iv);
  const encryptedData = cipher.update(data, 'utf8', 'base64') + cipher.final('base64');
  return encryptedData;
}

function decrypt_token(data) {
  const decipher = crypto.createDecipheriv('aes-256-cbc', key, iv);
  const decripted = decipher.update(data, 'base64', 'utf8') + decipher.final('utf8');
  return decripted;
}

console.log('NodeJS encrypt: ', encrypt_token('partnerId=1&amp;operationId=30215&amp;clientId=CDX12345&amp;timestamp=1545735181'));
console.log('NodeJS decrypt: ', decrypt_token('hxdBZWB4eNn0lstyQU3cIX3WPj4ZLZu-C8qD02QEex8ahvMSMagFJnAGr2C16qMGsOLIcqypO8NX4Tn65DCrXGKrEL5i75tj6WoHGyWAzs0'));


Note: I changed `aes-256-gcm` to `aes-256-cbc` in `encrypt_token` function to match the decryption algorithm used in `decrypt_token` function. Also, `gcm` mode requires additional parameters like `authTag` which was missing in your code. If you want to use `gcm` mode, you need to provide the `authTag` as well. 

Please be aware that the above code will work but it is not recommended to use `cbc` mode for encryption as it is not secure for encrypting large data. Use `gcm` mode instead. 

To use `gcm` mode, refer to the following example:


function encrypt_token(data) {
  const cipher = crypto.createCipheriv('aes-256-gcm', key, iv);
  const encryptedData = cipher.update(data, 'utf8', 'base64') + cipher.final('base64');
  const authTag = cipher.getAuthTag();
  return encryptedData + ':' + authTag.toString('base64');
}

function decrypt_token(data) {
  const parts = data.split(':');
  const encryptedData = parts[0];
  const authTag = Buffer.from(parts[1], 'base64');
  const decipher = crypto.createDecipheriv('aes-256-gcm', key, iv);
  decipher.setAuthTag(authTag);
  const decripted = decipher.update(encryptedData, 'base64', 'utf8') + decipher.final('utf8');
  return decripted;
}