const secureAi = require('secure-ai');

// Create an instance of SecureAICtx
const context = new secureAi.SecureAICtx();

// Set up encryption parameters
context.setEncryptionParameters({
  algorithm: 'AES-GCM',
  keySize: 256,
  ivSize: 128,
  encryptionKey: 'your_encryption_key_here',
  authenticationTagSize: 128
});

// Example usage
const sensitiveData = "Top secret information";
const encryptedData = context.encrypt(sensitiveData);
console.log("Encrypted Data:", encryptedData);

const decryptedData = context.decrypt(encryptedData);
console.log("Decrypted Data:", decryptedData);