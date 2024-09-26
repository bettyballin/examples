async function encryptString(key, plainText) {
  const iv = new Uint8Array(16);
  let encrypted;

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
        iterations: 100000, // adjust the number of iteration to your needs
        hash: { name: 'SHA-256' }
      },
      baseKey,
      { name: 'AES-CBC', length: 256 }, // or AES-GCM for authenticated encryption
      true,
      ['encrypt']
    );

    encrypted = await crypto.subtle.encrypt(
      {
        name: 'AES-CBC',
        iv: new Uint8Array(16) // use a random IV each time you encrypt and store it alongside the ciphertext
      },
      derivedKey,
      new TextEncoder().encode(plainText)
    );
  } catch (err) {
    console.error(err);
  }

  return btoa(String.fromCharCode.apply(null, new Uint8Array(encrypted)));
}

// Call the function
encryptString("myKey", "Hello, World!").then(encrypted => console.log(encrypted));