
const crypto = require('crypto');

// Generate a random key and iv for AES-256
const key = crypto.randomBytes(32);
const iv = crypto.randomBytes
