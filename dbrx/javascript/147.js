const sha3 = require('sha3');

let hash = new sha3.SHA3Hash();
hash.update('Hello world!');
console.log(hash.digest('hex'));