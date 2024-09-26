const cryptojs = require("crypto-js");

// Assuming decodedSecret and buffer are defined elsewhere in your code
let decodedSecret = 'your_secret_key_here';
let buffer = 'your_buffer_here';

// Step 1: Generate an HMAC-SHA-1 value
let decodedSecretWA = cryptojs.lib.WordArray.create(new Uint8Array(Buffer.from(decodedSecret, 'utf8')));
let bufferWA = cryptojs.lib.WordArray.create(Buffer.from(buffer, 'utf8'));
let hmacjsWA = cryptojs.algo.HMAC.create(cryptojs.algo.SHA1, decodedSecretWA);
hmacjsWA.update(bufferWA);
let hmacResultjsWA = hmacjsWA.finalize();
const hmacResultjs = Buffer.from(CryptJsWordArrayToUint8Array(hmacResultjsWA));

console.log(hmacResultjs);

// Helper function
function CryptJsWordArrayToUint8Array(wordArray) {
  const lsb = wordArray.words.length * 4;
  const uint8Array = new Uint8Array(lsb);
  for (let i = 0; i < lsb; i += 1) {
    uint8Array[i >>> 2] |= (wordArray.words[i >>> 2] >>> (24 - (i % 4) * 8)) & 0xFF;
  }
  return uint8Array;
}