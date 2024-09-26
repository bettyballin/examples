const crypto = require('crypto');

const iv = Buffer.alloc(12, 0);
crypto.randomFillSync(iv);

console.log(iv);