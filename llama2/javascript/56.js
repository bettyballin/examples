const JSRSA = require('jsrsasign');

// Generate a 2048-bit RSA key pair
const keypair = JSRSA.KEYUTIL.generateKeypair("RSA", 2048);

const publicKey = JSRSA.KEYUTIL.getPEM(keypair.pubKeyObj, "PKCS1");
const privateKey = JSRSA.KEYUTIL.getPEM(keypair.prvKeyObj, "PKCS1");

console.log(publicKey); // Print the public key in PEM format
console.log(privateKey); // Print the private key in PEM format