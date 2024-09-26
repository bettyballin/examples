const CryptoJS = require("crypto-js");

const secret = "secret";
const message = "test";

// Create a HMAC with SHA-256
const hmac = CryptoJS.algo.HMAC.create(CryptoJS.algo.SHA256, secret);

// Update the HMAC with the input data
hmac.update(message);

// Get the digest (bytes representation)
const digest = hmac.finalize();

console.log("Digest:", CryptoJS.enc.Hex.stringify(digest));