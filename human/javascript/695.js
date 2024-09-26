const crypto = require('crypto');

const publicKey = 'your_public_key_here';
const signedMessage = 'signedMessage';
const signatureBytes = 'signatureBytes';

const verify = crypto.createVerify('RSA-SHA256');
verify.update(signedMessage, 'utf8');
verify.end();

const verified = verify.verify(publicKey, signatureBytes, 'utf8');
console.log(verified);