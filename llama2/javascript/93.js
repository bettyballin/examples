const crypto = require('crypto');

const iv = new Uint8Array(16);
crypto.randomFillSync(iv);

console.log(`IV: ${iv}`);