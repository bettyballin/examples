const EC = require('elliptic').ec;
const ec = new EC('secp256k1');
const ecPrivateKey = ec.genKeyPair().priv;

const ecPublicKey = ec.keyFromPrivate(ecPrivateKey, 'hex').getPublic();