const EC = require('elliptic').ec;
const ec = new EC('secp256k1');

// Generate two starting keypairs
const key1 = ec.genKeyPair();
const key2 = ec.genKeyPair();

// Sum the public keys
const sum = key1.getPublic().add(key2.getPublic());

// Sum the private keys
const psum = key1.getPrivate().add(key2.getPrivate());

console.log("Public Key 1:", key1.getPublic().encode('hex'));
console.log("Public Key 2:", key2.getPublic().encode('hex'));
console.log("Sum Public Key:", sum.encode('hex'));
console.log("Private Key 1:", key1.getPrivate().toString('hex'));
console.log("Private Key 2:", key2.getPrivate().toString('hex'));
console.log("Sum Private Key:", psum.toString('hex'));