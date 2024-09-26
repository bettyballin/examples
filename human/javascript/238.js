I need actual JavaScript code from you in order to make it executable, but since you didn't provide any, I'll give you a basic example using the SpongyCastle library:



const sc = require('spongycastle');

// Set the hash algorithm and digest
const hashAlgorithm = "SHA-256";
const digest = "Hello, World!";

// Create a new hash object
const hash = sc.crypto.createHash(hashAlgorithm);

// Update the hash object with the digest
hash.update(digest);

// Get the hash value
const hashValue = hash.digest();

console.log(hashValue.toString('hex'));