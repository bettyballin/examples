const crypto = require('crypto');

// Your client nonce as a Buffer object
let clientNonce = 'your_client_nonce_here';
let clientNonceBuffer = Buffer.from(clientNonce, 'base64');

// Server nonce as a string or buffer depending on its format in the response.
function getServerNonce() {
    // Replace this with your actual server nonce retrieval logic
    return 'your_server_nonce_here';
}
let serverNonceStringOrBuffer = getServerNonce();

// Create an HMAC-SHA1 hash using your Nonce binary secret and seed (server nonce)
const hmacSHA1 = crypto.createHmac('sha1', clientNonceBuffer);
hmacSHA1.update(serverNonceStringOrBuffer);

// Get the signature as a base64 string
let signatureBase64 = hmacSHA1.digest().toString('base64');

console.log(signatureBase64);