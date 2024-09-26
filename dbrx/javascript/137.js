const CryptoJS = require("crypto-js");

const postData = { nonce: 100 };
const message = CryptoJS.SHA256(JSON.stringify(postData)).toString();

console.log(message);