
const forge = require('node-forge');

// Replace these with your modulus and private exponent in hexadecimal
const modulusHex = '...'; // n
const privateExponentHex = '...'; // d

// Convert hexadecimal values to big integers
const n = forge.jsbn.BigInteger.fromRadix(modulusHex, 16
