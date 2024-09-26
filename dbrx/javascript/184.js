const crypto = require('crypto');

function importJwk(jwk) {
  return new Uint8Array(crypto.createSecretKey(Buffer.from(jwk, 'base64')).export());
}

// Usage example:
const base64EncodedJwk = 'your-base64-encoded-jwk-string';
const key = importJwk(base64EncodedJwk);
console.log(key);