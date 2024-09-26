
const crypto = require('crypto');

// Generate Alice's keys
const alice = crypto.createDiffieHellman(2048);
const aliceKeys = alice.generateKeys();

// Generate Bob's keys
const bob = crypto.createDiffieHellman(alice.getPrime(), alice.getGenerator());
const bobKeys = bob.generateKeys();

// Compute the shared secret
const aliceSecret = alice.computeSecret(bobKeys);
const bobSecret = bob.computeSecret(aliceKeys);

// The shared secrets should be the same
console.log(aliceSecret.toString('hex') === bob
