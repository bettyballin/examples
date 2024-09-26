const crypto = require('crypto');

let pwd = "your_password_here";
var hash = crypto.createHash('sha256').update(pwd).digest('base64');

console.log(hash);