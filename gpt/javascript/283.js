
function mnemonicToSeed(mnemonic, passphrase = '') {
  window.crypto.subtle.importKey(
    'raw',
    stringToArrayBuffer(mnemonic),
    { name: 'PBKDF2' },
    false,
    ['deriveKey']
  )
  .then((importedKey) => {
    return window.crypto.subtle.deriveKey(
      {
        name: 'PBKDF2',
        salt: stringToArrayBuffer('mnemonic' + passphrase),
        iterations: 2048,
        hash: { name: 'SHA-512' }
      },
      importedKey,
      { name: 'HMAC', hash: 'SHA-512', length: 512 },
      true, // set extractable to true
      ['sign']
    );
 
