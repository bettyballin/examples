const crypto = require('crypto');

const algorithm = 'des-ede-cfb';
const secretKey = 'your_secret_key_here';
const iv = 'your_iv_here';

const decipher = crypto.createDecipheriv(algorithm, secretKey, iv);