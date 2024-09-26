const crypto = require('crypto');

var cipher = crypto.createCipheriv('rc4', 'secret', '');
var crypt = cipher.update('hello', 'utf-8', 'hex');
crypt += cipher.final('hex');

var decipher = crypto.createDecipheriv('rc4', 'secret', '');
var data = decipher.update(crypt, 'hex', 'utf-8'); 
data += decipher.final('utf-8');

console.log(data);