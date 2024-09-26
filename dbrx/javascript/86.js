const forge = require('node-forge');
const rsa = forge.pki.rsa;
const { BigInteger } = require('jsbn');

// Generate a key pair
let keys = rsa.generateKeyPair({bits: 2048, e: 0x10001});

// Get the private exponent (d) from the generated privateKey object
console.log(keys.privateKey.d.data);

// Create an RSA private key using modulus and d
let modulus = keys.privateKey.n;
let privateExponent = keys.privateKey.d;

let n = new BigInteger(modulus.toString(16), 16);
let d = new BigInteger(privateExponent.toString(16), 16);

let privateKey = rsa.setPrivateKey(n, null, null, null, null, d);

console.log(forge.pki.privateKeyToPem(privateKey));