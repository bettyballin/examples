
// You'll need to include CryptoJS or import it if using a module system
const CryptoJS = require("crypto-js");

// Your payload and secret key
const payload = JSON.stringify(yourData); // yourData should be an object of your payload
const secretKey = "your-secret-key";

// Calculate the HMAC
const hash = CryptoJS.HmacSHA256(payload,
