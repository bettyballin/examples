
const crypto = require('crypto');

const dataText = 'Hello';
const passphrase = '2C8E29E736CB9514DD93C4D111244990';
const key = crypto.createHash('md5').update(passphrase, 'utf-8').digest('hex').slice(0, 16);

const cipher = crypto.createCipheriv
