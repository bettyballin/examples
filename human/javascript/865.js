// Import CryptoJS library
const CryptoJS = require("crypto-js");

// Define encrypted data, key, and initialization vector
let encData = CryptoJS.enc.Hex.parse("D5F630E93F36C21293012D78E5A384F1");
let key = CryptoJS.enc.Hex.parse("A254FE00A791AA74386E8DEF3712B256");
let iv = CryptoJS.enc.Hex.parse("00000000000000000000000000000000");

// Decrypt data using AES
let data = CryptoJS.AES.decrypt(
    {ciphertext: encData}, 
    key, 
    {iv: iv, padding: CryptoJS.pad.NoPadding}
).toString(CryptoJS.enc.Hex);

// Log decrypted data
console.log(data); // c704469332aa61804601008a92dc10e5