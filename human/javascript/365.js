const CryptoJS = require("crypto-js");

let text = "Hello, World!";
let password = "mysecretpassword";

var encrypted = CryptoJS.AES.encrypt(text, password);

console.log(encrypted.toString());