const CryptoJS = require("crypto-js");

const communicationKey = CryptoJS.enc.Base64.parse("your_key_here");
const communicationIV = CryptoJS.enc.Base64.parse("your_iv_here");

var encrypted = CryptoJS.AES.encrypt("Message", communicationKey, {
    iv : communicationIV,
    mode: CryptoJS.mode.CFB
});

console.log(encrypted);