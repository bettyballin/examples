const CryptoJS = require("crypto-js");

const path = "your_path";
const message = "your_message";
const secret = "your_secret";

const hmacDigest = CryptoJS.HmacSHA512(path + message, secret);
postman.setEnvironmentVariable('API-Signature', CryptoJS.enc.Base64.stringify(hmacDigest));