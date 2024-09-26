const CryptoJS = require("crypto-js");

const SECRET_KEY = "your_secret_key_here";
const signatureRawData = "your_signature_raw_data_here";

var x = CryptoJS.enc.Base64.parse(SECRET_KEY).toString(CryptoJS.enc.Utf8);

var signatureRawDataBytes = CryptoJS.enc.Utf8.parse(signatureRawData);

var hash = CryptoJS.HmacSHA256(signatureRawDataBytes, x);