
const CryptoJS = require("crypto-js");

// The encrypted string you got from C#
const base64Value = '...'; // Base64 encoded encrypted string from C#

// The key used in C# (must be the same)
const key = '...'; // The key you're using for encryption/decryption

// The IV is the first 16 bytes of the key in the C# example
const iv = CryptoJS.enc.Utf8.parse(key.substring(0, 16));

// The rest of the key is used for the AES key
const aesKey = CryptoJS.enc.Utf8.parse(key);

const encryptedText = CryptoJS.enc.Base64.parse(base64Value);

const decrypted = CryptoJS
