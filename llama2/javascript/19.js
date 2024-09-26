const crypto = require('crypto-js');

// Define the message to be padded
const message = "Hello, World!";

// Pad the message with PKCS#7
const paddedMessage = crypto.lib.padding.pkcs7Pad(crypto.lib.WordArray.create(message), 16);

console.log(paddedMessage.toString());