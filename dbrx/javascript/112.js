const nacl = require('tweetnacl');

const secretKeyA = nacl.box.keyPair();
const secretKeyB = nacl.box.keyPair();

// Encrypt message from A to B.
const nonce = nacl.randomBytes(24);
const encryptedMessage = nacl.box(
  'Hello Bob!', 
  nonce, 
  secretKeyB.publicKey, 
  secretKeyA.secretKey
);

// Decrypt the received ciphertext at side of receiver (Bob).
const decryptedMessage = nacl.box.open(
  encryptedMessage, 
  nonce, 
  secretKeyA.publicKey, 
  secretKeyB.secretKey
);

console.log(decryptedMessage.toString());