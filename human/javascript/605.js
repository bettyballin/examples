const crypto = require('crypto');

const key_in_bytes = crypto.randomBytes(32); // 256-bit key
const iv = crypto.randomBytes(16); // 128-bit initialization vector

const cipher = crypto.createCipheriv('aes-256-ctr', key_in_bytes, iv);