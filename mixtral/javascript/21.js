const crypto = require('crypto');

function hashAndEncode(input) {
  const hash = crypto.createHash('sha256').update(input).digest();

  // Use base64url encoding
  return Buffer
    .from(hash, 'binary')
    .toString('base64')
    .replace(/=/g, '')
    .replace(/\+/g, '-')
    .replace(/\//g, '_');
}

const hashedToken = hashAndEncode("55q322q23");
console.log(`http://myurl.com/${hashedToken}`);