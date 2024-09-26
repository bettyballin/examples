
const { subtle } = require("crypto").webcrypto;

async function generateSharedSecret(foreignPublicKeyB64, nodePrivateKey) {
  // Decode the base64-encoded SPKI public key
  const foreignPublicKeyBuffer = Buffer.from(foreignPublicKeyB64, 'base64');

  // Import the foreign public key
 
