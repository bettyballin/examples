const crypto = require('crypto');

const username = "LoginUser";
const password = "LoginPass";

const usernameHash = crypto.createHash('sha256').update(username).digest('hex');
const passwordHash = crypto.createHash('sha1').update(password).digest('hex');
const combinedHash = crypto.createHash('sha256').update(username + password).digest('hex');

console.log(`SHA256(username=${username}) = ${usernameHash}`);
console.log(`SHA1(password=${password}) = ${passwordHash}`);
console.log(`SHA256((username + password)=${username}${password}) = ${combinedHash}`);