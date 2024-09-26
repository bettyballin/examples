const crypto = require('crypto');
const { privateKey } = require('./private_key');
const dataToSign = "DATA";

// Create a signer
let signer = crypto.createSign('RSA-SHA1');

signer.update(dataToSign);

// Sign the message
let signature = signer.sign({
    key: privateKey,
    padding: crypto.constants.RSA_PKCS1_PADDING
}, 'base64');

console.log('Signature in base64 format:', signature);