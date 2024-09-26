
const crypto = require('crypto');
const fs = require('fs');

function readPublicKey(path) {
    return fs.readFileSync(path, 'utf8');
}

function verifySignature(publicKey, signingInput, signature) {
    const verifier
