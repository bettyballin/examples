function hmacSha256(dataIn, key) {
  const crypto = require('crypto');
  const hmac = crypto.createHmac('sha256', key);
  hmac.update(dataIn);
  return hmac.digest();
}

// Test the function
const key = Buffer.from('your_secret_key_here', 'utf8');
const dataIn = Buffer.from('your_data_here', 'utf8');
const result = hmacSha256(dataIn, key);
console.log(result.toString('hex'));