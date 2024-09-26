async function generateKey(password, salt, iterations, lengthInBytes) {
  const keyMaterial = await window.crypto.subtle.importKey(
    "raw",
    new TextEncoder().encode(password),
    { name: "PBKDF2" },
    false,
    ["deriveBits"]
  );

  return window.crypto.subtle.deriveBits(
    {
      name: "PBKDF2",
      salt: new Uint8Array(salt),
      iterations: iterations,
      hash: "SHA-256",
    },
    keyMaterial,
    lengthInBytes * 8
  );
}

// Example usage:
generateKey("mysecretpassword", [1, 2, 3, 4, 5, 6, 7, 8], 1000, 32)
  .then((result) => console.log(result))
  .catch((error) => console.error(error));