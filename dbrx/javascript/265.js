const crypto = require('crypto');

function getSalt() {
  return crypto.randomBytes(32);
}

console.log(getSalt());