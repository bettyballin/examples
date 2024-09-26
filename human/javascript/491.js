const crypto = require('crypto');
const base64url = require('base64url');

const data = 'your data here';
const length = 16 - (data.length % 16);
const paddedData = data + Buffer.alloc(length, length).toString();

const iv = crypto.randomBytes(16);
const key = 'your key here';
const cipher = crypto.createCipheriv('aes-256-cfb', key, iv, { segmentSize: 128 });

cipher.update(paddedData);
const crypted = Buffer.concat([cipher.final(), iv]);

const entry = base64url(Buffer.concat([iv, crypted]));
console.log(entry);