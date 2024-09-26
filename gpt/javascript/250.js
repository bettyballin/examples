
const crypto = require('crypto');

// AES-128-GCM uses a 128-bit key (16 bytes)
const mykey = crypto.randomBytes(16);
const iv = crypto.randomBytes(12); // Recommended IV
