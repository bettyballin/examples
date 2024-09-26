const EC = require('elliptic').ec;
const crypto = require('crypto');

const ec = new EC('secp256k1');
let secret = crypto.createHash('sha256').update('password').digest('hex');
let keyPair = ec.keyFromSecret(secret, 'hex');

console.log(keyPair.getPrivate('hex'));
console.log(keyPair.getPublic('hex'));