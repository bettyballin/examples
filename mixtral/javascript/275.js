const crypto = require("crypto-js");

// Base64 decode payload
const payload = 'your_base64_encoded_payload'; // replace with your payload
const decodedPayload = Buffer.from(payload, 'base64').toString('utf8');
console.log('decoded:', decodedPayload);

// Parse JSON
const parsedPayload = JSON.parse(decodedPayload);

const iv = crypto.enc.Hex.parse(parsedPayload.iv);

// Convert ciphertext to WordArray
const crypttextWordArray = crypto.enc.Hex.parse(parsedPayload.encryptedData);

console.log('crypttext:', crypttextWordArray);

const key = 'fpK92jhnf914Kahqkecnml96l4apmgOf';

// Decryption
const plaintextArray = crypto.AES.decrypt(
  {
    ciphertext: crypttextWordArray
  },
  crypto.enc.Utf8.parse(key),
  {
    iv,
    mode: crypto.mode.CBC
  }
);

// Convert WordArray to string
const decryptedText = plaintextArray.toString(crypto.enc.Utf8);
console.log('decrypted text:', decryptedText);