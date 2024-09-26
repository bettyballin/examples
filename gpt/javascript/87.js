
// Import the necessary CryptoJS components
const CryptoJS = require("crypto-js");

// Your secret key and message (the assertion in your case)
const secret = CryptoJS.enc.Hex.parse('your-secret-key-in-hex');
const message = "The message you want to MAC";

// Calculate the CMAC
const cmac = CryptoJS.CMAC(secret, message);

// Convert
