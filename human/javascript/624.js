const bcrypt = require('bcrypt-nodejs');

const complete_string = "login" + "user@gmail.com";
const salt = bcrypt.genSaltSync(2);
console.log("salt: " + salt);

const hash = bcrypt.hashSync(complete_string, salt);
console.log("hash: " + hash);

console.log("compare: " + bcrypt.compareSync(complete_string, hash));