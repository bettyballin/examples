
const crypto = require('crypto');

// The key should be a Buffer or TypedArray. For simplicity, we convert the string to a Buffer.
const key = Buffer.from('secret');

// RC4 does not use an IV, but you still need to provide an empty Buffer instead of an empty string.
const cipher = crypto.createCipheriv('rc4', key, Buffer.alloc(0));
let crypt = cipher.update('hello
