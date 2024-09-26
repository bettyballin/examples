
async function deriveSharedSecret(privateKey, publicKey) {
  // Derive the shared secret from the ECDH key agreement
  const sharedSecret = await window.crypto.subtle.deriveBits(
    {
      name: "ECDH",
      public: publicKey
    },
    privateKey,
    256 // The desired bit length of the shared secret
  );
  return sharedSecret;
}

async function deriveAESKeyFromSharedSecret(sharedSecret) {
  // Use HKDF to derive an AES key from the shared secret
  const aesKey = await window.crypto.subtle.deriveKey(
    {
      name: "HKDF",
      hash: { name: "SHA-256" },
      salt:
