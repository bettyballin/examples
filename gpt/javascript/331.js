
var CryptoJS = require("crypto-js");

var payload = '...'; // your base64-encoded payload

// Decode the payload from base64 to a UTF-8 string
var decodedPayload = CryptoJS.enc.Base64.parse(payload).toString(CryptoJS.enc.Utf8);
console.log('decoded: ', decodedPayload);

// Parse the decoded payload to get the IV and encrypted data
var parsedPayload = JSON.parse(decodedPayload);
var iv = CryptoJS.enc.Hex.parse(parsedPayload.iv);
var encryptedData = CryptoJS.enc.Hex.parse(parsedPayload.encryptedData);

// The key should be encoded in the same format as the one used in the encryption
var key = CryptoJS.enc.Utf8.parse('fpK92jhnf914Kahqkecnml96l4apmgOf');

// Perform the decryption
var decrypted = CryptoJS.AES.decrypt(
    { ciphertext: encryptedData },
    key,
    {
        iv: iv,
        mode: CryptoJS.mode.CBC,
