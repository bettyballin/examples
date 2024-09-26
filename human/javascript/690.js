const crypto = require('crypto');

var buf1 = Buffer.from('308141020100301306072a8648ce3d020106082a8648ce3d030107042730250201010420', 'hex');
var buf2 = Buffer.from('your_raw_private_key_as_hex_string', 'hex'); // replace with your raw private key
var privateKeyPkcs8Der = Buffer.concat([buf1, buf2], buf1.length + buf2.length);

var dataToSign = 'your_data_to_sign'; // replace with your data to sign
var sign = crypto.createSign('SHA384');
sign.write(dataToSign);
sign.end();

var signature = sign.sign({ key: privateKeyPkcs8Der, format: 'der', type: 'pkcs8' });

console.log(signature.toString('hex'));