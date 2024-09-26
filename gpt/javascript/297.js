
const crypto = require('crypto');

// Your client nonce - make sure this is a Buffer or string that represents the binary data
const clientNonce = Buffer.from('your-client-nonce', 'binary');

// The server nonce - also a Buffer or string in binary format
const serverNonce = Buffer.from('server-nonce-from-response', 'binary');

// Combine the nonces to create the seed for PSHA1
const seed = Buffer.concat([clientNonce, serverNonce]);

// The shared secret/key that you'll use to sign the data
const sharedKey = 'your-shared-key'; // Make sure this is in the correct format

// Initialize the HMAC with the shared key and the SHA1 algorithm
const hmac = crypto.createH
