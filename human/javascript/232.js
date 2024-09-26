const crypto = require('crypto');

var cipher = crypto.createCipheriv('rc4', 'secret', '');
crypt = cipher.update('hello', 'utf8', 'binary');
crypt += cipher.final('binary');

var decipher = crypto.createDecipheriv('rc4','secret', '');
data = decipher.update(crypt, 'binary', 'utf8');
data += decipher.final('utf8');

console.log(data);