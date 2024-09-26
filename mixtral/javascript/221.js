async function mnemonicToSeed(mnemonic, passphrase = '') {
  const importedKey = await window.crypto.subtle.importKey(
    'raw',
    stringToArrayBuffer(mnemonic),
    { name: 'PBKDF2' },
    false,
    ['deriveBits']
  );

  const derivedBytes = await window.crypto.subtle.deriveKey(
    {
      name: 'PBKDF2',
      salt: stringToArrayBuffer('mnemonic' + passphrase),
      iterations: 2048,
      hash: 'SHA-512',
    },
    importedKey,
    {
      name: 'HMAC',
      hash: 'SHA-512',
      length: 64 * 8,
    },
    true,
    ['sign']
  );

  const seedBytes = await window.crypto.subtle.exportKey('raw', derivedBytes);

  let hexSeed = '';

  for (let i = 0; i < seedBytes.byteLength; ++i) {
    const byteValue = seedBytes[i];

    if ((byteValue & 15) <= 9) {
      hexSeed += '0' + byteValue.toString(16);
    } else {
      hexSeed += byteValue.toString(16);
    }
  }

  return hexSeed;
}

function stringToArrayBuffer(str) {
  const encoder = new TextEncoder('utf-8');
  return encoder.encode(str);
}

// Test the function
mnemonicToSeed('your_mnemonic_here', 'your_passphrase_here').then((seed) => {
  console.log(seed);
});