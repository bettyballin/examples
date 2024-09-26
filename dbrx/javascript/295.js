const generateEcdhKeys = async () => {
  const ecdhKeyPair = await window.crypto.subtle.generateKey(
    {
      name: 'ECDH',
      namedCurve: 'P-256', // or "prime256v1"
    },
    true, // whether the key is extractable (i.e. can be used in exportKey)
    ['deriveKey'] // Key usages
  );

  return ecdhKeyPair;
};

const importEcdhPublicKey = async (publicKeyBase64) => {
  const publicKeyBinary = window.atob(publicKeyBase64);
  const publicKeyBuffer = new Uint8Array(
    Array.from(publicKeyBinary).map((char) => char.charCodeAt(0))
  ).buffer;

  return await window.crypto.subtle.importKey(
    'spki',
    publicKeyBuffer,
    {
      name: 'ECDH',
      namedCurve: 'P-256', // or "prime256v1"
    },
    true, // whether the key is extractable (i.e. can be used in exportKey)
    ['deriveKey'] // Key usages
  );
};

const deriveSharedSecret = async (privateKey, publicKeyBase64) => {
  const importedPublicKey = await importEcdhPublicKey(publicKeyBase64);

  return await window.crypto.subtle.deriveBits(
    {
      name: 'ECDH',
      namedCurve: 'P-256', // or "prime256v1"
      public: importedPublicKey,
    },
    privateKey, // your private key here
    128 * 8 // desired bit length of the shared secret (e.g AES-128)
  );
};

(async () => {
  const keyPair = await generateEcdhKeys();
  const publicKeyBase64 = btoa(String.fromCharCode(...new Uint8Array(await window.crypto.subtle.exportKey('spki', keyPair.publicKey))));
  const sharedSecret = await deriveSharedSecret(keyPair.privateKey, publicKeyBase64);
  console.log(sharedSecret);
})();