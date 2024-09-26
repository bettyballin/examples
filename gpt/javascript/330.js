
async function pbkdf2_derive_salted_key(key, salt, iterations, length) {
  return crypto.subtle.deriveBits(
    {
      name: "PBKDF2",
      salt: salt,
      iterations: iterations,
      hash: {name: "SHA-1"},
    },
    key,
    length
  );
}

// Usage
const salt = str2binb("QSXCR+Q6sek8bf92"); // Convert string to ArrayBuffer
const key = await pbkdf2_generate_key_from_string("pencil");
