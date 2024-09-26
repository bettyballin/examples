async function pbkdf2(password, salt) {
  const passwordBuffer = new TextEncoder().encode(password);
  const importedPassword = await crypto.subtle.importKey(
    'raw',
    passwordBuffer,
    { name: 'PBKDF2' },
    false,
    ['deriveBits']
  );

  return window.crypto.subtle.deriveBits(
    {
      name: "PBKDF2",
      hash: "SHA-256", // or SHA-512
      salt: new Uint8Array(salt),
      iterations: 10000 // adjust as needed
    },
    importedPassword,
    16 * 8 // output length in bits (adjust as needed)
  );
}

const password = 'your-password';
const salt = crypto.getRandomValues(new Uint8Array(16));

pbkdf2(password, salt).then(result => console.log(new Uint8Array(result)));