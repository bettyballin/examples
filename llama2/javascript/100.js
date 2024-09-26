function goog_crypto(string_to_sign, secret) {
  const hmac = new goog.crypt.Hmac(new goog.crypt.Sha1(), goog.crypt.stringToByteArray(secret));
  return hmac.getHmac(forceUnicodeEncoding(string_to_sign)).toString();
}

// Define the goog.crypt object
const goog = {
  crypt: {
    Hmac: class {
      constructor(algorithm, key) {
        this.algorithm = algorithm;
        this.key = key;
      }

      getHmac(data) {
        const crypto = require('crypto');
        const hmac = crypto.createHmac(this.algorithm.constructor.name.toUpperCase(), this.key);
        hmac.update(data);
        return hmac.digest();
      }
    },
    Sha1: class {},
    stringToByteArray: function(str) {
      const bytes = [];
      for (let i = 0; i < str.length; i++) {
        bytes.push(str.charCodeAt(i));
      }
      return bytes;
    }
  }
};

// Define the forceUnicodeEncoding function
function forceUnicodeEncoding(str) {
  return str.split('').map(c => c.charCodeAt(0)).toString();
}

// Example usage:
const stringToSign = "Hello, World!";
const secret = "my_secret_key";
console.log(goog_crypto(stringToSign, secret));