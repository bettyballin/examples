const EC = require('elliptic').ec;
const bn128 = new EC('p521');
const { base64url } = require("rfc4648");

// Generate a random private key
let d = bn128.genKeyPair().getPrivate();

// Create public point from the generator and our secret
let pubPoint = bn128.g.mul(d);

console.log(`x: ${base64url(pubPoint.getX().toArrayLike(Buffer, 'be', 57))}`);
console.log(`y: ${base64url(pubPoint.getY().toArrayLike(Buffer, 'be', 57))}`);