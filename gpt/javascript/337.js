
import CryptoJS from "crypto-js";

// Create a 256-bit key from a password
const password = "my secret";
const keySize = 256;
const key = CryptoJS.PBKDF2(password, CryptoJS.lib.WordArray.random(128/8), {
    keySize: keySize/32,
    iterations: 100
});

// Fixed IV
const iv = CryptoJS.lib.WordArray.create([0x20212223, 0x24252627, 0x28292a2b, 0x2c2d2e2f]);

// Encryption
const message = "my message";
const encrypted = CryptoJS.AES
