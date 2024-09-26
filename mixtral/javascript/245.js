const nacl = require('tweetnacl');
const base58 = require('bs58');
const someStringMessage = 'your_message_here';
const keyPair = { secretKey: 'your_secret_key_here' };

const message = Buffer.from(someStringMessage, 'hex');

// Decode the secret key from Base58
const decodedSecretKey = base58.decode(keyPair.secretKey);

try {
  // Sign the message using TweeTNaCl
  const signature = nacl.sign(message, decodedSecretKey);

  console.log(`Signature: ${Buffer.from(signature).toString('hex')}`);
} catch (error) {
  if ('bad secret key size' === error.message) {
    throw new Error(`The provided Base58-encoded 'secretKey' doesn't correspond to a valid Ed25519 private key.`);
  }

  // Re-throw other errors
  throw error;
}