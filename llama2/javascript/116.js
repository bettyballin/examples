const nacl = require('tweetnacl');

const message = new TextEncoder().encode("Hello, World!");
const naclPair = nacl.sign.keyPair();

const signature = nacl.sign(message, naclPair.secretKey);

console.log(nacl.sign.verify(signature, message, naclPair.publicKey));