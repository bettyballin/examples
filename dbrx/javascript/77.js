const CryptoJS = require("crypto-js");
const secretKey = 'your-private-key';
const payloadData = { foo: 'bar' }; // replace with your actual payload data
const dataToSign = JSON.stringify(payloadData);
const hmacSignature = CryptoJS.HmacSHA256(dataToSign, secretKey).toString(CryptoJS.enc.Base64);
console.log(hmacSignature);