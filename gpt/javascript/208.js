
// JavaScript
var sharedSecret = "YOUR_SECRET_KEY";
var timestamp = Math.floor(Date.now() / 1000); // Current time in seconds
var uniqueCode = sha256(sharedSecret + timestamp); // Use a hash function like SHA-256

