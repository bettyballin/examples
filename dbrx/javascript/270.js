async function decryptString(key, encryptedText) {
  const iv = new Uint8Array(16);
  let decrypted;

  try {
    // Generate a key from the password using PBKDF2 algorithm
    const baseKey = await crypto.subtle.importKey(
      'raw',
      new TextEncoder().encode(key),
      { name: 'PBKDF2' },
      false,
      ['deriveBits', 'deriveKey']
    );

    const derivedKey = await crypto.subtle.deriveKey(
      {
        name: 'PBKDF2',
        salt: iv,
        iterations: 1000,
        hash: 'SHA-256'
      },
      baseKey,
      {
        name: 'AES-GCM',
        length: 256
      },
      true,
      ['encrypt', 'decrypt']
    );

    // Decrypt the string
    decrypted = await crypto.subtle.decrypt(
      {
        name: 'AES-GCM',
        iv: iv
      },
      derivedKey,
      new Uint8Array(encryptedText.match(/.{1,2}/g).map(byte => parseInt(byte, 16)))
    );

    return new TextDecoder().decode(decrypted);
  } catch (error) {
    console.error(error);
  }
}

// Example usage
decryptString('mySecretKey', 'yourEncryptedText').then(decrypted => console.log(decrypted));