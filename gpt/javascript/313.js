
const { generateKeyPairSync, createSign } = require('crypto');

// Your key generation code here...

// Example message
const message = 'The quick brown fox jumps over the lazy dog';

// Sign the message
const signer = createSign('sha256');
signer.update(message);
signer.end();
const signature = signer.sign({ key: privateKey, passphrase: '' }, 'base64');

// Prepare the public key by removing the header/footer and newlines
