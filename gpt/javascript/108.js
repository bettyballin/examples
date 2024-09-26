
const crypto = require('crypto');

function createWebSafeHash(input) {
  // Create a hash of the input
  const hash = crypto.createHash('md5').update(input).digest('base64');
  // Replace '+' with '-', '/' with '_', and remove '='
  const webSafeHash = hash.replace(/\+/g, '-').replace(/\//g, '_').replace(/=+$/, '');
  return webSafeHash;
}

const hashedToken = createWebSafeHash("55q322q23");
console.log(hashedToken); // Should print a URL-safe base64 string

