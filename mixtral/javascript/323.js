const crypto = require('crypto');
const fs = require('fs');

function readKeyPair(path) {
    return {
        publicKey: fs.readFileSync(path.publicKey, 'utf8'),
        privateKey: fs.readFileSync(path.privatePath, 'utf8')
    }
}

// Signature verification
const verifySignature = (headerAndPayload, signature, keyPair) =>
  crypto
      .createVerify('RSA-SHA256')
      .update(`${headerAndPayload}.`)
      .verify(keyPair.publicKey, Buffer.from(signature, 'base64'));

const JWT = (
    'eyJhbGciOiJS...etc'
);

// Split the token into its parts
let [headerB64UrlEncoded, payloadB64UrlEncoded, signature] =
  JWT.split('.');

// Decode base64url encoded headers and payload
const decoder = new TextDecoder('utf-8');

const base64ToArrayBuffer = (base64String) => {
  const binaryString = atob(base64String.replace(/-/g, '+').replace(/_/g, '/'));
  const len = binaryString.length;
  const bytes = new Uint8Array(len);
  for (let i = 0; i < len; i++) {
    bytes[i] = binaryString.charCodeAt(i);
  }
  return bytes.buffer;
};

let headerAndPayload = `${decoder
    .decode(base64ToArrayBuffer(headerB64UrlEncoded))}.${decoder
            .decode(base64ToArrayBuffer(payloadB64UrlEncoded))}`;

// Verify the signature
const keyPairPath = {
  publicKey: 'rs256.key.pub',
  privateKey: 'rs256.key'
};

console.log(`Signature verification result is ${verifySignature(headerAndPayload, signature, readKeyPair(keyPairPath))}`);