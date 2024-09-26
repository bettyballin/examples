const ec = require('elliptic').ec;
const fs = require('fs');

const keyPair = ec('secp256k1').genKeyPair();

const privateKeyHex = keyPair.getPrivate().toString('hex');

const skeyPath = 'path_to_your_file.txt'; // replace with your file path

fs.writeFileSync(skeyPath, privateKeyHex);