async function generateRsaKeyPair() {
  const keyGenParams = {name: 'RSA-OAEP', modulusLength: 2048, publicExponent: new Uint8Array([1, 0, 1])};
  return await window.crypto.subtle.generateKey(keyGenParams, true, ['encrypt', 'decrypt']);
}

const keyPair = await generateRsaKeyPair();
console.log(keyPair);