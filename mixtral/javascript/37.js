// Import CryptoJS library
const CryptoJS = require('crypto-js');

// Function to encrypt AES secret key with RSA public key
function rsaEncrypt(rsaKey, aesSecretKey) {
  const cipher = CryptoJS.RSA.encrypt(aesSecretKey, rsaKey).toString();
  return cipher;
}

// Function to decrypt encrypted AES key with RSA private key
function rsaDecrypt(rsaPrivateKey, encryptedAESkey) {
  try {
    var bytes = CryptoJS.RSA.decrypt(encryptedAESkey, rsaPrivateKey, {
      keySize: 2048 / 8,
      padding: CryptoJS.pad.ZeroPadding
    });
    var decryptedKey = bytes.toString(CryptoJS.enc.Utf8);
    return decryptedKey;
  } catch (e) {
    console.log("Error: " + e);
    return null;
  }
}

// Example usage:
const rsaPublicKey = "-----BEGIN PUBLIC KEY-----...-----END PUBLIC KEY-----";
const rsaPrivateKey = "-----BEGIN PRIVATE KEY-----...-----END PRIVATE KEY-----";
const aesSecretKey = "my_secret_key";

const encryptedKey = rsaEncrypt(rsaPublicKey, aesSecretKey);
console.log("Encrypted Key: " + encryptedKey);

const decryptedKey = rsaDecrypt(rsaPrivateKey, encryptedKey);
console.log("Decrypted Key: " + decryptedKey);