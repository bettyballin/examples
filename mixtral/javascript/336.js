window.crypto.subtle
  .importKey(
    "raw", // The import format
    new TextEncoder().encode("password"), // Your password as an ArrayBuffer
    {   // The key usages
      name: "PBKDF2"
    },
    false, // Whether the key is extractable
    ["deriveBits"]
  )
  .then(key => console.log(key))
  .catch(err => console.error(err));