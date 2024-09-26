
const array = new Uint8Array(16); // For AES 128-bit key
window.crypto.getRandomValues(array);
// Now 'array' contains cryptographically secure random bytes

