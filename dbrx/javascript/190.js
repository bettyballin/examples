const CryptoJS = require("crypto-js");

const key = "your_key_here";
const iv = "your_iv_here";
const crypttext = "your_ciphertext_here";

var plaintextArray = CryptoJS.AES.decrypt(
    {
        ciphertext: CryptoJS.enc.Hex.parse(crypttext),
        salt: ''
    },
    Buffer.from(key),
    { 
        iv: CryptoJS.enc.Hex.parse(iv), 
        mode: CryptoJS.mode.CBC, 
        padding: CryptoJS.pad.Pkcs7 
    }
);

console.log(plaintextArray.toString(CryptoJS.enc.Utf8));