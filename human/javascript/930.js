const crypto = require('crypto');

const algorithm = 'RSA_PKCS1_PADDING';
const cipher = crypto.createCipheriv(algorithm, '', '');