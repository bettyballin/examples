
const crypto = require('crypto');

const username = "LoginUser";
const password = "LoginPass";

const SHA1 = s => crypto.createHash('sha1').update(s).digest();
const SHA256 = s => crypto.createHash('sha256').update(s).digest();
const SHA256Hex = s => crypto.createHash('sha256').update(s).digest('hex');

let step1 = SHA256(username); // This is a raw buffer
let step2 = SHA1(password); // Also a raw buffer

// Concatenate the raw buffers, then hash
let step3 = SHA256(Buffer.concat([step
