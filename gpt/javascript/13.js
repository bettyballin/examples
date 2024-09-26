
// Include CryptoJS library
var CryptoJS = require("crypto-js");

// Secret key (ensure this is securely shared with the PHP side)
var key = 'your-encryption-key';

// Encrypt the message
var message = '12345';
var encrypted = CryptoJS.AES.encrypt(message, key).toString();

// Now, you can pass 'encrypted' in your
