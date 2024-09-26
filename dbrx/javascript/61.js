const EC = require('elliptic').ec;
const ec = new EC('secp256k1');
const assert = require('assert');

// Generate private keys (skA, skB)
let skA = '0x1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef';
let skB = '0x9876543210fedcba9876543210fedcba9876543210fedcba9876543210fedcba';

// Generate private key shares (skA, skB)
let pkA = ec.keyFromPrivate(skA, 'hex');
let pkB = ec.keyFromPrivate(skB, 'hex');

// Data to sign
let data = 'Hello, World!';

// Partial signing on each device:
let sigPartA = pkA.sign(data); // Signature part A
let sigPartB = pkB.sign(data); // Signature part B

// Combine signature parts (assuming you have both):
const combinedSignature = {
  r: sigPartA.r.add(sigPartB.r),
  s: sigPartA.s.add(sigPartB.s)
};

// Verify the final threshold-based ECDSA signature:
let pubKeyCombined = ec.keyFromPublic(pkA.getPublic().add(pkB.getPublic()));
assert(pubKeyCombined.verify(data, combinedSignature));