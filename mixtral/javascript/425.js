function generatePrivateKey(crypto = window.crypto) {
  if (!crypto || !crypto.getRandomValues) throw new Error("Crypto API not available");

  const privateKeyBytes = new Uint8Array(32); // 256 bits for a Bitcoin private key

  crypto.getRandomValues(privateKeyBytes);

  return Array
    .from(privateKeyBytes)
    .map((byte) => byte.toString(16).padStart(2, '0'))
    .join('');
}

console.log(generatePrivateKey());