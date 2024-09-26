const crypto = window.crypto || require('crypto').webcrypto;

function getCryptoSecureFloat(min, max) {
  const uint32Array = new Uint32Array(1);

  // Generate a cryptographically secure random integer
  crypto.getRandomValues(uint32Array);

  let floatValue = (uint32Array[0] / Math.pow(2, 32)) * (max - min) + min;

  return parseFloat(floatValue.toFixed(15));
}

// Usage
console.log("Cryptographically secure random float:", getCryptoSecureFloat(0, 1));