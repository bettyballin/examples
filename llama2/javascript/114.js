import CryptoJS from "crypto-js";

const password = "mysecretpassword"; // Define the password
const iv = CryptoJS.lib.WordArray.create([0x20212223, 0x24252627, 0x28292a2b, 0x2c2d2e2f]);
const key = CryptoJS.PBKDF2(password, "salt", { keySize: 4/32, iterations: 1000 });
const plaintext = "my message";
const ciphertext = CryptoJS.AES.encrypt(plaintext, key, { iv: iv, mode: CryptoJS.mode.CBC });
console.log(ciphertext.toString());