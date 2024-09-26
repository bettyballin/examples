
// Hash a string
var text = "Hello, World!";
var hash = sjcl.hash.sha256.hash(text);
var digest = sjcl.codec.hex.fromBits(hash);

console.log("SHA-256 Hash:", digest);

