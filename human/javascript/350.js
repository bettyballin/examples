const EC = require('elliptic').ec;
const ec = new EC('secp256k1');

// Generate private keys
var privateKey1 = ec.keyFromPrivate('0x1234567890abcdef');
var privateKey2 = ec.keyFromPrivate('0xfedcba0987654321');

// Combine private keys
var privateKeySum = ec.keyFromPrivate(ec.add(privateKey1, privateKey2));

// Get the corresponding public key
var publicKeySum = privateKeySum.getPublic();

// Sign the message with our new combined private key
var msg = [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ];
var signature = privateKeySum.sign(msg);

// Export DER encoded signature in Array
var derSign = signature.toDER();

// Verify signature using the combined public key, should return true
console.log(publicKeySum.verify(msg, derSign));