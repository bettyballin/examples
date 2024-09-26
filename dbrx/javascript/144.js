function mnemonicToSeed(mnemonic, passphrase = '') {
  return crypto.subtle.importKey(
    'raw',
    new TextEncoder().encode(mnemonic),
    { name: 'PBKDF2' },
    false,
    ['deriveKey']
  ).then((importedKey) => {
    const salt = `mnemonic${passphrase}`;
    return crypto.subtle.deriveKey({
      name: 'PBKDF2',
      salt: new TextEncoder().encode(salt),
      iterations: 2048,
      hash: { name: 'SHA-512' }
    }, importedKey, {
      name: 'HMAC',
      hash: 'SHA-512',
      length: 512
    }, true, ['sign']
    ).then((derivedKey) => crypto.subtle.exportKey('raw', derivedKey));
  }).then((exportedKey) => new Uint8Array(exportedKey)).then((uint8Arr) =>
    Array.from(uint8Arr).map(b => b.toString(16).padStart(2, '0')).join('')
  );
}

// Example usage:
mnemonicToSeed('your mnemonic phrase', 'your passphrase').then(seed => console.log(seed));