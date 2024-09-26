const CryptoJS = require('crypto-js');

// Your encrypted data from Python code (base64 encoded)
let encryptedData = "SxQE+SERkAzYcdG/ESAhiQ==";

// Convert base 64 string into a WordArray object for decryption process.
encryptedData = CryptoJS.enc.Base64.parse(encryptedData);

const key = 'key'; // Your encryption password

// Decrypt the data using AES-128 with ECB mode and PKCS7 padding
let decryptedData = CryptoJS.AES.decrypt(
    { ciphertext: encryptedData },
    CryptoJS.enc.Utf8.parse(key),
    {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
    }
);

// Convert the WordArray object back to a string (UTF-8)
decryptedData = decryptedData.toString(CryptoJS.enc.Utf8);

console.log(decryptedData);