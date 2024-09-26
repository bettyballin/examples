const CryptoJS = require('crypto-js');

const cryptkey = CryptoJS.enc.Utf8.parse('1234567890123456');
const iv = CryptoJS.enc.Hex.parse("0000000000000000");

// Convert the encrypted data from Base64 format
var cryptdata = "8Z3dZzqn05FmiuBLowExK0CAbs4TY2GorC2dDPVlsn/tP+VuJGePqIMv1uSaVErr";
cryptdata = CryptoJS.enc.Base64.parse(cryptdata);

var decryptedData = CryptoJS.AES.decrypt({
    ciphertext: cryptdata
}, cryptkey, {
   iv:iv
});

console.log("Decrypted Data : " + decryptedData.toString(CryptoJS.enc.Utf8));