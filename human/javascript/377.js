const crypto = require('crypto');

let password = "your_password";
let e = "your_salt";

let res = crypto.pbkdf2Sync(password, e, 10000, 32, 'sha1');
console.log(res.toString('hex'));