const CryptoJS = require('crypto-js');

let encData = hex2bin("D5F630E93F36C21293012D78E5A384F1");
let key = hex2bin("A254FE00A791AA74386E8DEF3712B256");

// Convert from Hex string to WordArray
encData = CryptoJS.enc.Hex.parse(encData);
key = CryptoJS.enc.Hex.parse(key);

const iv = CryptoJS.lib.WordArray.random(16); // Generate random IV if not provided

let decrypted = CryptoJS.AES.decrypt(
  {
    ciphertext: encData,
    key: key,
    iv: iv,
  },
  {
    mode: CryptoJS.mode.CBC, // Use CBC as the default padding is PKCS7
    padding: CryptoJS.pad.ZeroPadding,
  }
);

// Set encoding to 'hex' instead of converting manually
let data = decrypted.toString(CryptoJS.enc.Hex);
console.log(data);

function hex2bin(hex) {
  return hex.match(/.{1,2}/g).map((x) => parseInt(x, 16));
}