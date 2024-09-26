const CryptoJS = require("crypto-js");

var key = CryptoJS.enc.Base64.parse("your_base64_encoded_key");
var data = "your_base64_encoded_data";

var base64data = CryptoJS.enc.Base64.parse(data);

var encrypted = new CryptoJS.lib.WordArray.init(base64data.words.slice(4));
var iv = new CryptoJS.lib.WordArray.init(base64data.words.slice(0, 4));

var cipher = CryptoJS.lib.CipherParams.create({ ciphertext: encrypted });

var decrypted = CryptoJS.AES.decrypt(cipher, key, {iv: iv, mode: CryptoJS.mode.CFB});

console.log(decrypted.toString(CryptoJS.enc.Utf8));