const crypto = require('crypto');

const data = "When in Rome do as the Romans do";
const key = "2e35f242a46d67eeb74aabc37d5e5d05";

const iv = crypto.randomBytes(16);
const cipher = crypto.createCipheriv('aes-128-cbc', Buffer.from(key, 'hex'), iv);
const encrypted = Buffer.concat([cipher.update(data), cipher.final()]);

const ivAndEncrypted = Buffer.concat([iv, encrypted]);
const base64String = ivAndEncrypted.toString('base64');

console.log(base64String);