const EC = require('elliptic').ec;
const ec = new EC('secp256k1');

// generate two new random keypairs
var privateKeySum = ec.genKeyPair();
var publicKeySum = ec.genKeyPair();

// assuming psum and sum variables are defined somewhere
var psum = '...some private key...';
var sum = '...some public key...';

// we don't care about their values
// so just import the sum of keys into them
privateKeySum._importPrivate(psum);
publicKeySum._importPublic(sum);