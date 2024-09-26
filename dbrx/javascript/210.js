const crypto = require('crypto');
const scrypt = require('scrypt');

function encrypt(data, password) {
  const salt = crypto.randomBytes(16);
  const key = scrypt.kdfSync(password, { N: 16384, r: 8, p: 1 }, 32, 'buffer', null);

  // Generate random IVs for each encryption operation
  const ivContent = crypto.randomBytes(12);
  const ivHash = crypto.randomBytes(12); 

  const cipherContent = crypto.createCipheriv('aes-256-gcm', key, ivContent);
  let encryptedData = Buffer.concat([cipherContent.update(data), cipherContent.final()]);

  // Encrypt hash of plaintext
  const hasher = crypto.createHmac('sha256', password).update(encryptedData.toString());
  const hashedValue = hasher.digest();

  return {
    data: encryptedData,
    ivs: [ivContent, ivHash],
    salt: salt
  };
}

function decrypt(dataObj, password) {
  // Derive key from user-provided password and stored salt
  const derivedKey = scrypt.kdfSync(password, { N: 16384, r: 8, p: 1 }, 32, 'buffer', dataObj.salt);

  // Decrypt encrypted data
  const decipherContent = crypto.createDecipheriv('aes-256-gcm', derivedKey, dataObj.ivs[0]);
  let decryptedData = Buffer.concat([decipherContent.update(dataObj.data), decipherContent.final()]);

  // Verify decrypted data
  const hasher = crypto.createHmac('sha256', password).update(decryptedData.toString());
  const expectedHash = hasher.digest();

  if (expectedHash.equals(dataObj.ivs[1])) {
    return decryptedData.toString();
  } else {
    throw new Error('Data integrity verification failed');
  }
}

// Example usage:
const data = 'Hello, World!';
const password = 'mysecretpassword';

const encrypted = encrypt(data, password);
console.log('Encrypted:', encrypted);

const decrypted = decrypt(encrypted, password);
console.log('Decrypted:', decrypted);