async function pbkdf2_derive_salted_key(key, data, salt, iterations) {
  const hmac = await crypto.subtle.importKey(
    "raw",
    new TextEncoder().encode(key),
    { name: "HMAC", hash: "SHA-256" },
    false,
    ["sign"]
  );

  const saltedKey = await crypto.subtle.deriveKey(
    {
      name: "PBKDF2",
      salt: new TextEncoder().encode(salt),
      iterations: iterations,
      hash: "SHA-256",
    },
    hmac,
    { name: "AES-GCM", length: 256 },
    false,
    ["encrypt", "decrypt"]
  );

  const encrypted = await crypto.subtle.encrypt(
    {
      name: "AES-GCM",
      iv: new Uint8Array(12),
    },
    saltedKey,
    new TextEncoder().encode(data)
  );

  return encrypted;
}

// Test the function
pbkdf2_derive_salted_key("mykey", "Hello, World!", "mysalt", 1000).then((encrypted) => {
  console.log(encrypted);
});