const crypto = require('crypto');

const plainText = 'your_plain_text_here';
const privateKey = 'your_private_key_here';

const signature = crypto.createSign('RSA-SHA256');
signature.update(plainText);
signature.end();

const signed = signature.sign(privateKey, 'base64');
console.log(signed);