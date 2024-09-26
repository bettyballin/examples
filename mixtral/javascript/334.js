async function generateSharedKey(privateKey, publicKey) {
  const ecdhSecret = await window.crypto.subtle.deriveBits({
    name: "ECDH",
    namedCurve: 'P-256', 
    public: publicKey,
    private: privateKey
  }, 256);

  return new Uint8Array(ecdhSecret);
}

async function deriveAESGCMkeyWithHKDF(secret, salt = null){
  const keyMaterial = await window.crypto.subtle.importKey(
    'raw',
    secret,
    {name: 'HMAC', hash: 'SHA-256'},
    false,
    ['sign']
  );

  return window.crypto.subtle.deriveBits({
    name: "HKDF",
    hash: "SHA-256",
    salt: salt ? new Uint8Array(salt) : new Uint8Array(),
    info: new Uint8Array(),
    iterations: 1
  }, keyMaterial, 32 * 8);
}

async function deriveSecretKey(privateKey, publicKey) {
  const sharedECDH = await generateSharedKey(privateKey, publicKey);
  const aesGcmKey = await deriveAESGCMkeyWithHKDF(sharedECDH);

  return window.crypto.subtle.importKey(
    'raw',
    new Uint8Array(aesGcmKey),
    'AEAD_AES_256_GCM',
    false,
    ['encrypt', 'decrypt']
  );
}