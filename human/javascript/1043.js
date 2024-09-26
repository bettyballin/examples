const EC = require('elliptic').ec;
const BN = require('bn.js');
const ec = new EC('secp256k1');

function bnToB64(bn) {
  return Buffer.from(bn.toArrayLike(Buffer, 'be', bn.byteLength())).toString('base64');
}

const dHex = 'your_hex_string_here'; // replace with your hex string

const point = ec.curve.g.mul(new BN(dHex, 16, 'be'));
console.log(`actual   x: ` + bnToB64(point.getX()));
console.log(`actual   y: ` + bnToB64(point.getY()));