const base64url = require('base64url');
const base16 = require('base16');

const padBase16ToWholeOctets = (hexString) => {
  const bytes = hexString.match(/.{1,2}/g);
  return bytes.map((byte) => byte.padStart(2, '0')).join('');
};

const bnToB64 = (n) => base64url.stringify(base16.parse(padBase16ToWholeOctets(n.toString(16)).padStart(132, '0')));

// Test the function
console.log(bnToB64(12345678901234567890));