import { HmacSHA256 } from 'crypto-js';
import { Base64 } from 'js-base64'; // for base64 encoding/decoding

const nonce = new Date().getTime();
const secretKey = "your_secret_key";

function signature(nonce, secretKey) {
  const hmacSha256 = HmacSHA256(Base64.encode(String(nonce)), secretKey);
  return Base64.encode(hmacSha256.toString());
}

console.log(signature(nonce, secretKey));