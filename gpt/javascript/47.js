
async function generateKey() {
  const key = await window.crypto.subtle.generateKey(
    { name: "AES-CBC", length: 256 }, // Algorithm the key will be used with
    true, // Whether the key is extractable
    ["encrypt", "decrypt"] // Intended us
