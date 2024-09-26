const elliptic = require('elliptic');
const BN = require('bn.js');

// Providing ecies_key_derivation https://github.com/indutny/elliptic/issues/9
const ec = new elliptic.ec('secp256k1');

// Replace with your own private key
const onetime_private_key = 'your_onetime_private_key_here';
const s0 = ec.keyPair({ priv: onetime_private_key, privEnc: 'hex' });

// Replace with receiver's private key
const d_receiver_hex = 'receiver_private_key_here';
const s1 = ec.keyPair({ priv: d_receiver_hex, privEnc: 'hex' });

const sh0 = s0.derive(s1.getPublic());
const sh1 = s1.derive(s0.getPublic());

console.assert(sh0.toString(16) === sh1.toString(16), "shared secret did not match");

const shared_secret = "0" + sh0.toString(16);
console.log(shared_secret);