
const crypto = require('crypto');

var array = new Uint32Array(10);
crypto.randomFillSync(array);

console.log(array);

