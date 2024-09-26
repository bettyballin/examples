const subtle = window.crypto.subtle;

// Import the recipient's public key
const recipientPublicKeyData = new Uint8Array([/* insert public key data here */]);
const recipientPublicKey = await subtle.importKey(
  'raw',
  recipientPublicKeyData,
  {
    name: 'ECDH',
    namedCurve: 'P-256'
  },
  true,
  ['deriveBits']
);