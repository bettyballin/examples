
function generatePrivateKey() {
  const privateKeyBytes = new Uint8Array(32); // 256 bits for a Bitcoin private key
  window.crypto.getRandomValues(privateKeyBytes);

  // Convert byte array to hexadecimal string
  const privateKeyHex = Array.from(privateKeyBytes)
    .map(byte => byte.toString(16).padStart(2, '0'))
    .join('');

  // Ensure the private key is in the valid range [1, n - 1] for the Bitcoin curve (secp256k1).
  // 'n' is the order of the curve which is a fixed value for secp256k1.
  const n = BigInt('0xfffffffffffffffffffffffffffffffebaaedce6af48a03bbfd25e8cd0364141');
  let privateKeyBigInt = BigInt('0x' + privateKeyHex);

  // In the unlikely event
