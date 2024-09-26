
const nacl = require('tweetnacl');
const base58 = require('bs58');
const sha256 = require('js-sha256').sha256;

// ... (your existing functions)

// Decode the base58 secret key to get the seed
const seed = base58.decode(keyPair.secretKey).slice(5, 37); //
