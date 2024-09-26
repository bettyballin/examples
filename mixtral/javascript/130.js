const crypto = require('crypto');

function hmac(key, payload) {
  return crypto
    .createHmac('sha256', key)
    .update(payload)
    .digest('hex')
}

// Usage:
let privateKey = 'my-private-key';
let dataToSend = JSON.stringify({ foo: 'bar' });

let hmacHash = hmac(privateKey, dataToSend);
console.log(hmacHash);