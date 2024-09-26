const crypto = require('crypto');

const buffer = Buffer.from('1e43d1c5e88853622efe39e7a838cebf01cf3029589a614274', 'hex').slice(0, 21);
const hash = crypto.createHash('sha256').update(buffer).digest('buffer');
const finalHash = crypto.createHash('sha256').update(hash).digest('buffer');

console.log(finalHash.toString('hex'));