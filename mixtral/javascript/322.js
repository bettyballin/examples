const sodium = require('libsodium-wrappers');

function generateEncryptionKeys() {
  const publicKey = sodium.sodium_malloc(sodium.crypto_box_PUBLICKEYBYTES);
  const secretKey = sodium.sodium_malloc(sodium.crypto_box_SECRETKEYBYTES);

  if (!publicKey || !secretKey) {
    throw new Error("Failed to allocate memory for keys");
  }

  sodium.crypto_box_keypair(publicKey, secretKey);

  return { 
    publicKey: Buffer.from(publicKey), 
    secretKey: Buffer.from(secretKey) 
  };
}

// Example usage:
const keys = generateEncryptionKeys();
console.log(keys);