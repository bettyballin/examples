const crypto = require("crypto");

const SECRET_KEY = "RANDOMKEY";
const MD5 = crypto.createHash("MD5");
MD5.update(SECRET_KEY, 'ucs2');
const keyStart = MD5.digest().slice(0, 8);

const valueToEncrypt = 'password\r\n';
const cipher = crypto.createCipheriv('des-cbc', keyStart, keyStart);
const cryptedPassword = cipher.update(valueToEncrypt, 'utf8', 'base64') +
    cipher.final('base64');

console.log(cryptedPassword);