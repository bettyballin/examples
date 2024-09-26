const crypto = require('crypto');
const CryptoJS = require('crypto-js');
const base32 = require('hi-base32');

function dynamicTruncationFn(hmacResult) {
  const offset = hmacResult[hmacResult.length - 1] & 0xf;
  return (hmacResult[offset] << 24) | (hmacResult[offset + 1] << 16) | (hmacResult[offset + 2] << 8) | hmacResult[offset + 3];
}

function generateHOTP(secret, counter) {
  const decodedSecret = Buffer.from(base32.decode.asBytes(secret));

  // Step 1: Generate an HMAC-SHA-1 value
  let hmacjs = CryptoJS.algo.HMAC.create(CryptoJS.algo.SHA1, decodedSecret);
  hmacjs.update(Buffer.alloc(8));
  console.log(hmacjs.finalize().toString());

  const hmac = crypto.createHmac('sha1', Buffer.from(decodedSecret));
  hmac.update(Buffer.alloc(8));
  const hmacResult = hmac.digest();
  console.log(hmacResult.toString('hex'));

  // Step 2: Generate a 4-byte string (Dynamic Truncation)
  const code = dynamicTruncationFn(hmacResult);

  // Step 3: Compute an HOTP value
  return code % Math.pow(10, 6);
}

function generateTOTP(secret, window = 0) {
  const counter = Math.floor(Date.now() / 30000);
  return generateHOTP(secret, counter + window);
}

console.log(generateTOTP('GEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQGEZDG', 0));