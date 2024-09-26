import CryptoJS from "crypto-js";

const iv = CryptoJS.lib.WordArray.create([0x20212223, 0x24252627, 0x28292a2b, 0x2c2d2e2f]);

// Create a Cipher object with AES algorithm and the provided key
const cipher = CryptoJS.algo.AES.createEncryptionCipher(
  CryptoJS.enc.Hex.parse("my secret"), // Key
  { iv: iv }
);

cipher.start();

// Encrypt message in blocks
const message = "my message";
for (let i = 0; i < message.length / 4 + 1; ++i) {
  cipher.update(CryptoJS.lib.WordArray.create([
    message.charCodeAt(i * 4),
    message.charCodeAt(i * 4 + 1) || 0,
    message.charCodeAt(i * 4 + 2) || 0,
    message.charCodeAt(i * 4 + 3) || 0
  ]));
}

cipher.finalize();

// Convert encrypted data to base64
const a = cipher.concat().toString(CryptoJS.enc.Base64);
console.log(a);