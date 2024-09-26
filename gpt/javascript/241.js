
const CryptoJS = require("crypto-js");

const cryptkey = CryptoJS.enc.Utf8.parse('1234567890123456');
const iv = CryptoJS.enc.Hex.parse('00000000000000000000000000000000');
const crypted = "8Z3dZzqn05FmiuBLowExK0CAbs4TY2GorC2dDPVlsn/tP+VuJGePqIMv1uSaVErr";

// Since the encrypted data is Base64, we need to convert it to a CipherParams object
const cipherParams = CryptoJS.lib.CipherParams.create({
    ciphertext: CryptoJS.enc.Base64.parse(crypted)
});

var decrypted = CryptoJS.AES.decrypt(cipherParams, cryptkey, {
    iv: iv,
    mode
