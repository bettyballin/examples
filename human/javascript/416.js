const crypto = require('crypto');

const alicePublicKey = '043a3770a8068738ded16c9409e1a6fbf6dde2360ac5b3fd3e5bb8d9fd6adaed6ea83ff5153f58ae13098e86da89df1beb14ef46388d3df76e8fe2ee0ff9e926d5';
const bobPublicKey = '04aeceba6ae783c9b705833c2fa8822281f47f6f36bc867e4d398fa7a744d4fc63a010cbce1e6c9ac8858ad376a24ee8551615560f01c8bb63c86335c046b18962';
const sharedSecret = 'c26c9f370f001a947d7fec4dc9282d3e9ea718e1de487eb4f6fa7d6f0a311b97';

const aliceKey = Buffer.from(alicePublicKey, 'hex');
const bobKey = Buffer.from(bobPublicKey, 'hex');

const alice = crypto.createECDH('secp256k1');
alice.setPrivateKey(
  crypto.createDiffieHellman(bobKey).generateKeys()
);

const bob = crypto.createECDH('secp256k1');
bob.setPrivateKey(
  crypto.createDiffieHellman(aliceKey).generateKeys()
);

const aliceSharedSecret = alice.computeSecret(bobKey);
const bobSharedSecret = bob.computeSecret(aliceKey);

console.log(aliceSharedSecret.toString('hex') === sharedSecret);
console.log(bobSharedSecret.toString('hex') === sharedSecret);