const crypto = require('crypto');
const CryptoJS = require('crypto-js');
const base32 = require('hi-base32');

function dynamicTruncationFn(hmacResult) {
  const offset = hmacResult[hmacResult.length - 1] & 0xf;
  return (hmacResult[offset] & 0x7f) << 24 |
         (hmacResult[offset + 1] & 0xff) << 16 |
         (hmacResult[offset + 2] & 0xff) << 8 |
         (hmacResult[offset + 3] & 0xff);
}

function generateHOTP(secret, counter) {
  const decodedSecret = Buffer.from(base32.decode.asBytes(secret));

  const hmac = crypto.createHmac('sha1', decodedSecret);
  hmac.update(Buffer.alloc(8));
  const hmacResult = hmac.digest();

  const code = dynamicTruncationFn(hmacResult);

  return code % Math.pow(10, 6);
}

function generateTOTP(secret, window = 0) {
  const counter = Math.floor(Date.now() / 30000);
  return generateHOTP(secret, counter + window);
}

console.log(generateTOTP('GEZDGNBVGY3TQOJQGEZDG', 0));