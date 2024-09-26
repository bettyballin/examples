Here is the corrected and executable JavaScript code:


var crypto = require('crypto');
var c = new Date();
var x = (c.getTime() + "." + c.getMilliseconds()).toString();
var key = 'sevsolut';

var iv = new Buffer.from(key).slice(0, 16);
var cipher = crypto.createCipheriv("aes-256-cbc", new Buffer(32).fill(0), iv);

let encryptedPassword = cipher.update(x, 'utf8', 'binary') + cipher.final('binary');

console.log('encrypted : ', encryptedPassword);

// Decryption

var decipher = crypto.createDecipheriv("aes-256-cbc", new Buffer(32).fill(0), iv);
let decryptedPassword = decipher.update(new Buffer.from(encryptedPassword, 'binary'), 'binary', 'utf8') + decipher.final('utf8');

console.log('decrypted : ', decryptedPassword);