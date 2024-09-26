const crypto = require('crypto');

const salt = 'your-salt-value';
const initialKey = 'your-initial-key-value';

const PRK = crypto.createHmac('sha256', salt).update(initialKey).digest();
const key = crypto.createHmac('sha256', PRK).update(Buffer.concat([Buffer.from("encryption key"), Buffer.from([0x01])])).digest();
const IV = crypto.createHmac('sha256', PRK).update(Buffer.concat([Buffer.from("nonce"), Buffer.from([0x01])])).digest();

console.log(`PRK: ${PRK.toString('hex')}`);
console.log(`key: ${key.toString('hex')}`);
console.log(`IV: ${IV.toString('hex')}`);