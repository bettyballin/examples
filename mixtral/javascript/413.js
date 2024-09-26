const crypto = require('crypto');

function hkdf(secret, info) {
  const prk = crypto.createHmac("sha256", Buffer.from([0x01])).update(secret).digest();

  return function (length) {
    let t = Buffer.allocUnsafe(0);

    for (let i = 1; ; ++i) {
      const hmac = crypto
        .createHmac("sha256", prk)
        .update(`${info}${Buffer.from([i])}`).digest();

      t = Buffer.concat([t, hmac]);

      if (length <= 32 * i || length < t.byteLength - 1) {
        return t.slice(0, length);
      }
    }
  };
}

const sharedSecret = "your_secret_key"; // replace with your secret key
const deriveKey = hkdf(sharedSecret, "password_reset");

// Generate a private key of desired size (e.g 64 bits or 8 bytes)
const privateKeyBytes = Buffer.from(deriveKey(32)).slice(0, 8);

// Convert the byte array to an alphanumeric string
let privateKeyString = "";
for (let byte of privateKeyBytes) {
    const charCode = byte % 36;
    const char = charCode < 10 ? String.fromCharCode(charCode + 48) : String.fromCharCode(charCode + 87);
    privateKeyString += char;
}

console.log(privateKeyString);