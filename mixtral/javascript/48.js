const fs = require('fs');
const crypto = require('crypto');

var pubKey = fs.readFileSync('public_key.pem', 'utf8');
var signatureBase64 = 'your_signature_base64_string'; // replace with your signature
var buffer = Buffer.from('your_data', 'utf8'); // replace with your data

var verify = crypto.createVerify('RSA-SHA256');
verify.update(buffer);
verify.end();

var isValid = verify.verify(pubKey, signatureBase64, 'base64');

console.log(isValid);