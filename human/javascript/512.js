const CryptoJS = require("crypto-js");

const cryptkey = CryptoJS.enc.Utf8.parse('1234567890123456');
const crypted = CryptoJS.enc.Base64.parse("8Z3dZzqn05FmiuBLowExK0CAbs4TY2GorC2dDPVlsn/tP+VuJGePqIMv1uSaVErr");

var decrypt = CryptoJS.AES.decrypt({ciphertext: crypted}, cryptkey, {
    iv: CryptoJS.enc.Hex.parse('00000000000000000000000000000000'),
    mode: CryptoJS.mode.CBC,
    padding: CryptoJS.pad.Pkcs7
});

console.log(decrypt.toString(CryptoJS.enc.Utf8));