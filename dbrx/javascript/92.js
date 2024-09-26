async function protectPrivateKey(privateKey, password) {
  const salt = crypto.getRandomValues(new Uint8Array(16));
  const iterations = 100000;
  const hashAlgo = 'SHA-256';
  const derivedParams = { name: 'PBKDF2', salt, iterations, hash: hashAlgo };
  const keyMaterial = await window.crypto.subtle.importKey(
    'raw',
    new TextEncoder().encode(password),
    { name: 'PBKDF2' },
    false,
    ['deriveBits']
  );
  const aesGcmParams = {
    name: 'AES-GCM',
    length: 256,
    iv: crypto.getRandomValues(new Uint8Array(12)),
  };
  return await window.crypto.subtle.deriveKey(
    derivedParams,
    keyMaterial,
    { name: 'AES-GCM', length: 256 },
    false,
    ['encrypt', 'decrypt']
  );
}

async function encryptPrivateKey(privateKey, password) {
  const aesGcmKey = await protectPrivateKey(privateKey, password);
  const aesGcmParams = {
    name: 'AES-GCM',
    iv: crypto.getRandomValues(new Uint8Array(12)),
    additionalData: new Uint8Array(16),
  };
  // Encrypt the private key using AES-GCM
  return await window.crypto.subtle.encrypt(
    aesGcmParams,
    aesGcmKey,
    privateKey.extractable ? privateKey : await crypto.subtle.exportKey('pkcs8', privateKey)
  );
}

async function decryptPrivateKey(privateKeyEncrypted, password) {
  const aesGcmKey = await protectPrivateKey(password);
  const aesGcmParams = {
    name: 'AES-GCM',
    iv: new Uint8Array(12), // Must match the iv used in encryption
    additionalData: new Uint8Array(16), // Must match the additionalData used in encryption
  };
  // Decrypt the private key using AES-GCM
  return await window.crypto.subtle.decrypt(aesGcmParams, aesGcmKey, privateKeyEncrypted);
}

// Test the functions
async function test() {
  const privateKey = await window.crypto.subtle.generateKey(
    {
      name: 'RSASSA-PKCS1-v1_5',
      modulusLength: 2048,
      publicExponent: new Uint8Array([1, 0, 1]),
      hash: 'SHA-256',
    },
    true,
    ['sign']
  );
  const password = 'mysecretpassword';
  const encryptedPrivateKey = await encryptPrivateKey(privateKey, password);
  const decryptedPrivateKey = await decryptPrivateKey(encryptedPrivateKey, password);
  console.log(decryptedPrivateKey);
}

test();