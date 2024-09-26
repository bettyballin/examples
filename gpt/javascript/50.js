
const crypto = require('crypto');

var word = 'testing';
var hex = Buffer.from(word, 'utf-8').toString('hex');
// hex is '74657374696e67', not '740065007300740069006e006700'

var hash = crypto.createHash('sha512').update(hex, 'hex').digest('hex');

console.log(hash);

