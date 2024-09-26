// Utility functions
function hex2Arr(hex) {
  return new Uint8Array(hex.match(/.{1,2}/g).map(byte => parseInt(byte, 16)));
}

function buf2Hex(buffer) {
  return Array.prototype.map.call(new Uint8Array(buffer), x => ('00' + x.toString(16)).slice(-2)).join('');
}

// Alice's public key (received over an [insecure] connection)
const alicePublicKeyHex = '043a3770a8068738ded16c9409e1a6fbf6dde2360ac5b3fd3e5bb8d9fd6adaed6ea83ff5153f58ae13098e86da89df1beb14ef46388d3df76e8fe2ee0ff9e926d5';
const alicePublicKey = hex2Arr(alicePublicKeyHex);
console.log(`Alice's publicKey: ${alicePublicKeyHex}`);

let bob = null;

// Generate Bob's private and public key
window.crypto.subtle.generateKey(
  {
    name: 'ECDH',
    namedCurve: 'P-256'
  },
  false, // No need to make Bob's private key exportable
  ['deriveKey', 'deriveBits']
)
.then(bobKey => {
  bob = bobKey;
  // Export Bob's public key
  return window.crypto.subtle.exportKey(
    'raw',
    bobKey.publicKey
  );
})
.then(bobPublicKeyExported => {
  const bobPublicKeyHex = buf2Hex(bobPublicKeyExported);
  // Display and send Bob's public key to Alice
  console.log(`Bob's publicKey: ${bobPublicKeyHex}`);

  // Import Alice's public key
  return window.crypto.subtle.importKey(
    'raw',
    alicePublicKey,
    {
      name: 'ECDH',
      namedCurve: 'P-256'
    },
    true,
    []
  );
})
.then(aliceKeyImported => {
  // Use Alice's imported public key and
  // Bob's private key to compute the shared secret
  return window.crypto.subtle.deriveBits(
    {
      name: 'ECDH',
      namedCurve: 'P-256',
      public: aliceKeyImported
    },
    bob.privateKey,
    256
  );
})
.then(sharedSecret => {
  const sharedSecretHex = buf2Hex(sharedSecret);
  console.log(`sharedSecret: ${sharedSecretHex}`);
})
.catch(err => {
  console.log(err);
});