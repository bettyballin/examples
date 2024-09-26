
const crypto = require('crypto');
const secret = 'secret'; // This should be kept safe and secure
const algorithm = 'aes-256-cbc';
const key = crypto.scryptSync(secret, '
