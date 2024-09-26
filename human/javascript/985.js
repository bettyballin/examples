const CryptoJS = require("crypto-js");

const mess = "your_message_here"; // replace with your message
const key = "your_key_here"; // replace with your key

const hash = CryptoJS.HmacSHA256(CryptoJS.enc.Hex.parse(mess), key);
console.log(hash.toString());