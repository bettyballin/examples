
const crypto = require('crypto');
const nacl = require('tweetnacl');

// Assuming 'data' is a string or buffer that you want to hash
// and 'nonce' is the nonce you're using for secretbox

// Generate a SHA256 hash as a buffer (32 bytes)
const keyBuffer = crypto.createHash('sha256').update(data).digest();

// Now, if you need to use this key with tweetnacl, you can convert it to a Uint8Array
const keyUint8Array = new Uint8Array(keyBuffer);

// Use the keyUint8Array with secretbox
const encrypted = nacl.secretbox
