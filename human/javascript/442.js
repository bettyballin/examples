const CryptoJS = require("crypto-js");

var encrypted = "your_base64_encoded_encrypted_text";
var theKey = "your_rc4_key";

var decrypted = CryptoJS.RC4.decrypt({
    ciphertext: CryptoJS.enc.Base64.parse(encrypted)
}, CryptoJS.enc.Latin1.parse(theKey));

console.log(decrypted.toString(CryptoJS.enc.Utf8));