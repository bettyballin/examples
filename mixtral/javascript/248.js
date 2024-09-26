const crypto = require('crypto');

function goog_crypto(string_to_sign, secret) {
  const hmac = crypto.createHmac('sha256', secret);
  hmac.update(string_to_sign);
  return hmac.digest();
}

function goog_crypt_byteArrayToBase64String(byteArray) {
  return Buffer.from(byteArray).toString('base64');
}

const string_to_sign = "your_string_to_sign";
const secret = "your_secret";

const sig2 = goog_crypto(string_to_sign, secret);

let b64Sig2 = goog_crypt_byteArrayToBase64String(sig2);

console.log(b64Sig2);