const crypto = require('crypto');

// Base64 encoded RSA public key of Bob
let othersRsa2048PublicKey = 'your_base64_encoded_public_key_here';

// Decode base64 encoded RSA public keys
let othersRsa2048PublicKeyDecoded = Buffer.from(othersRsa2048PublicKey, 'base64');

// Alice's public key in base64 format
let alicePublicKeyBase64 = 'your_base64_encoded_alice_public_key_here';

const encryptedAliceDHForBob = crypto.publicEncrypt({
  key: othersRsa2048PublicKeyDecoded
}, Buffer.from(alicePublicKeyBase64, 'base64'));

// Send the `encryptedAliceDHForBob` to Bob
console.log(encryptedAliceDHForBob.toString('base64'));