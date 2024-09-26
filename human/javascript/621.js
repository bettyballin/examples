const SHA3 = require('sha3');

const hash = new SHA3(512);

hash.update('foo');
const filename = hash.digest('hex');

console.log(filename);