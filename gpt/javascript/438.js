
const elliptic = require('elliptic');
const EC = elliptic.ec;

// Create an instance of the elliptic curve
const ec = new EC('p521');

// Function to convert a BN (Big Number) to a base64url-encoded string
const bnToBase64url = (bn) => {
    // Ensure the buffer has a leading zero if the high bit is set for positivity in big-endian encoding
    let hex = bn.toString(16);
    if (hex.length % 2) {
        hex = '0' + hex;
   
