const CryptoJS = require('crypto-js');

// Replace 'secret_key' with your actual secret key
const secretKey = 'secret_key';

const req = {};
req['nonce'] = 123456; // Replace with your actual nonce value
const postdata = 'foo=bar&baz=qux';

// Convert postdata to a URL-encoded string
const encodedPostdata = encodeURIComponent(postdata);

// Calculate the signature
const signature = CryptoJS.HmacSHA512(encodedPostdata, secretKey).toString(CryptoJS.enc.Hex);

// Print the signature
console.log(signature);