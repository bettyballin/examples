const crypto = require('crypto');
const { subtle } = require('crypto').webcrypto;

async function generateKeyPair() {
  const keyPair = await subtle.generateKey(
    {
      name: 'RSASSA-PKCS1-v1_5',
      modulusLength: 2048,
      publicExponent: new Uint8Array([0x01, 0x00, 0x01]),
      hash: 'SHA-256',
    },
    true,
    ['sign', 'verify']
  );

  const publicKey = keyPair.publicKey;

  subtle.exportKey(
    'spki',
    publicKey
  ).then((exportedKey) => {
    const pubKey = crypto.createPublicKey(exportedKey);
    console.log(pubKey);
  });
}

generateKeyPair();