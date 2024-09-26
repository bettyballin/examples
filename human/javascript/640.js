const crypto = require('crypto');

function HMACSHA256(secret, message) {
  const hmac = crypto.createHmac('sha256', Buffer.from(secret));
  hmac.update(Buffer.from(message));
  return hmac.digest('hex');
}

console.log(HMACSHA256([1, 2, 3, 4, 5, 6], [7, 8, 9, 10]));