const crypto = require('crypto');

function goog_crypto(string_to_sign, secret) {
    const hmac = crypto.createHmac('sha1', secret);
    hmac.update(string_to_sign);
    return hmac.digest('base64');
}

// Helper function to ensure unicode encoding
function forceUnicodeEncoding(str) {
    return Buffer.from(str, 'utf8').toString('utf8');
}

// Test the function
console.log(goog_crypto("Hello, World!", "my_secret_key"));