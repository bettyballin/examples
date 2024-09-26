const CryptoJS = require("crypto-js");
const data = JSON.stringify({abc: 'xyz'});

const encrypted = CryptoJS.AES.encrypt(data, "my-secret");
console.log(encrypted.toString());

const decrypted = CryptoJS.AES.decrypt(encrypted.toString(), "my-secret");
const object = JSON.parse(decrypted.toString(CryptoJS.enc.Utf8));
console.log(object);
console.log(object.abc);