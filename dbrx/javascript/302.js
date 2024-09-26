Here is the corrected and executable JavaScript code:


const subtle = window.crypto.subtle;

async function main() {
  // Generate RSA-OAEP keys instead (more suitable for encryption/decryption)
  const keyDetails = await subtle.generateKey(
    {
      name: 'RSA-OAEP',
      modulusLength: 2048,
      publicExponent: new Uint8Array([0x01, 0x00, 0x01]),
      hash: { name: 'SHA-256' },
    },
    true,
    ['encrypt', 'decrypt']
  );

  // Export the private key in PKCS8 format
  const privateKeyPkcs8 = await subtle.exportKey('pkcs8', keyDetails.privateKey);
  console.log('Private Key (PKCS8):', new Uint8Array(privateKeyPkcs8));

  // Import the public key from JWK to a CryptoKey object with RSA-OAEP algorithm
  const publicKeyJwk = await subtle.exportKey('jwk', keyDetails.publicKey);
  const importedPublicKey = await subtle.importKey(
    'jwk',
    {
      ...publicKeyJwk,
      alg: 'RSA-OAEP',
      ext: true,
    },
    {
      name: 'RSA-OAEP',
      hash: { name: 'SHA-256' },
    },
    false, // extractable
    ['encrypt']
  );

  // Encrypt data using the imported public key (CryptoKey object)
  const enc = new TextEncoder();
  const encodedText = enc.encode('testing 1234');
  console.log('Original text:', encodedText);
  const encryptedData = await subtle.encrypt(
    {
      name: 'RSA-OAEP',
    },
    importedPublicKey,
    encodedText
  );

  // Decrypt data using the private key
  const decryptedData = await subtle.decrypt(
    {
      name: 'RSA-OAEP',
    },
    keyDetails.privateKey,
    encryptedData
  );
  const dec = new TextDecoder();
  console.log('Decrypted text:', dec.decode(decryptedData));
}

main();