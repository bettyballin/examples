const CryptoJS = require("crypto-js");

let key = CryptoJS.enc.Hex.parse('000102030405060708090a0b0c0d0e0f');
let ciphertext = CryptoJS.lib.WordArray.create([0x12, 0x34, 0x56, 0x78, 0x90, 0xab, 0xcd, 0xef]);

let data = CryptoJS.AES.decrypt({ciphertext: ciphertext}, key, {padding: CryptoJS.pad.ZeroPadding});
console.log(CryptoJS.enc.Hex.stringify(data));