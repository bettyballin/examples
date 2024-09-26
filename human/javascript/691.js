const crypto = require('crypto');

var buf1 = Buffer.from('3059301306072a8648ce3d020106082a8648ce3d030107034200', 'hex'); 
var buf2 = Buffer.from('your_raw_public_key_here', 'hex'); 
var publicKeyX509Der = Buffer.concat([buf1, buf2], buf1.length + buf2.length);
var dataToSign = 'your_data_to_sign_here';
var signature = 'your_signature_here';

var verify = crypto.createVerify('SHA384');    
verify.write(dataToSign);
verify.end();
var verified = verify.verify({ key: publicKeyX509Der, format: 'der', type: 'spki' }, signature);

console.log(verified);