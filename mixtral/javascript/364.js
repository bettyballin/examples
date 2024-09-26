// Generate key
const generateKey = async () => {
  const key = await window.crypto.subtle.generateKey(
    {
      name: "AES-GCM",
      length: 128,
    },
    true,
    ["encrypt", "decrypt"]
  );

  // Export the generated key as a base64 string
  const exported_key = await window.crypto.subtle.exportKey("raw", key);

  return sjcl.codec.base64.fromBits(new Uint8Array(exported_key));
};

// Encrypt data using SubtleCrypto
const encryptDataSubtleCrypto = async (data, aesKey) => {
  // Import the key
  const imported_key = await window.crypto.subtle.importKey(
    "raw",
    sjcl.codec.base64.toBits(aesKey),
    {
      name: "AES-GCM",
    },
    false,
    ["encrypt", "decrypt"]
  );

  // Encrypt the data
  const encrypted_data = await window.crypto.subtle.encrypt(
    {
      name: "AES-GCM",
      iv: new Uint8Array(12),
    },
    imported_key,
    new Uint8Array(data)
  );

  return sjcl.codec.base64.fromBits(new Uint8Array(encrypted_data));
};

// Example usage
generateKey().then((key) => {
  const data = new Uint8Array([1, 2, 3, 4, 5]);
  encryptDataSubtleCrypto(data, key).then((encrypted_data) => {
    console.log(encrypted_data);
  });
});