const CryptoJS = require("crypto-js");

const IV_MESSAGE = "your_iv_message";
const API_SECRET = "your_api_secret";

export const encrypt = (stringData) => {
   const iv = CryptoJS.SHA256(IV_MESSAGE).toString().substring(0, 16);

   // Convert the secret key to a WordArray
   let apiSecretWordArray = CryptoJS.enc.Utf8.parse(API_SECRET);

   const encrypted = CryptoJS.AES.encrypt(stringData, apiSecretWordArray, {
     iv: CryptoJS.enc.Hex.parse(iv),
     mode: CryptoJS.mode.CBC,
     padding: CryptoJS.pad.Pkcs7
   });

   return encrypted.toString();
};