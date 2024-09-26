const crypto = require('crypto');

const username = "LoginUser";
const password = "LoginPass";
const nonce = "1234567890";

const LowerCase = (s) => s.toLowerCase();
const Hex = (s) => Buffer.from(s, 'utf8').toString('hex');

const SHA1 = (s) => crypto.createHash('sha1').update(s, 'utf8').digest('hex');
const SHA1Raw = (s) => crypto.createHash('sha1').update(s, 'utf8').digest();

const SHA256 = (s) => crypto.createHash('sha256').update(s, 'utf8').digest('hex');
const SHA256Raw = (s) => crypto.createHash('sha256').update(s, 'utf8').digest();

const UTF8Encode = (s) => Buffer.from(s, 'utf8');

let step1 = SHA256Raw(username); // Get the SHA256 as a buffer.
let step2 = SHA1Raw(password); // Get the SHA1 as a buffer.
let step3 = SHA256Raw(Buffer.concat([step1, step2])); // Get the SHA256 of the previous steps concatenated as a buffer.

console.log(`
SHA256(username=${username})                            =    ${step1.toString('hex')}
SHA1(password=${password})                              =    ${step2.toString('hex')}
SHA256((username + password)=${username + password})      =    ${step3.toString('hex')}
`);