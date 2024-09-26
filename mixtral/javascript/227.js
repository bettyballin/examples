const pemEncodedKey = `-----BEGIN EC PRIVATE KEY-----\
base64PrivateKeyHere\
-----END EC PRIVATE KEY-----`;

// Extracting Base64 encoded key
let matches = pemEncodedKey.match(/-----BEGIN EC PRIVATE KEY-----(.*?)-----END EC PRIVATE KEY-----/gs);
const base64PrivateKey = matches[0].replace(/-----BEGIN EC PRIVATE KEY-----|-----END EC PRIVATE KEY-----/g, '');

console.log(base64PrivateKey);