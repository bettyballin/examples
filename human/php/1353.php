This is not PHP code, it's Node.js code. Here is the corrected version:

javascript
const crypto = require("crypto");
const secret = 'xxxxxxxxxxxxxxxxxxxx';

class HKDF {
  constructor(hashAlg, salt, ikm) {
    this.hashAlg = hashAlg;

    // create the hash alg to see if it exists and get its length
    const hash = crypto.createHash(this.hashAlg);
    this.hashLength = hash.digest().length;
    this.salt = salt || Buffer.alloc(this.hashLength).fill(0).toString();
    this.ikm = ikm;

    // now we compute the PRK
    const hmac = crypto.createHmac(this.hashAlg, this.salt);
    hmac.update(this.ikm);
    this.prk = hmac.digest();
  }

  derive(info, size) {
    let prev = Buffer.alloc(0);
    let output;
    const buffers = [];
    const num_blocks = Math.ceil(size / this.hashLength);
    info = Buffer.from(info);

    for (let i = 0; i < num_blocks; i++) {
      const hmac = crypto.createHmac(this.hashAlg, this.prk);
      hmac.update(prev);
      hmac.update(info);
      hmac.update(Buffer.from([i + 1]));
      prev = hmac.digest();
      buffers.push(prev);
    }

    output = Buffer.concat(buffers, size);
    return output;
  }
}

function decrypt(code) {
  if (typeof code !== 'string')
    return false;
  code = code.substring(128);
  const buff = Buffer.from(code, 'base64');
  const iv = buff.slice(0, 16);
  const encryptedText = buff.slice(16).toString('base64');
  const hkdf = new HKDF('sha512', null, secret);
  const derive_key = hkdf.derive('encryption', secret.length);
  const key = derive_key.slice(0, 16);
  const decipher = crypto.createDecipheriv('aes-128-cbc', key, iv);
  let result = decipher.update(encryptedText, 'base64', 'utf8');
  result += decipher.final('utf8');
  return result.replace(/[']/g, '');
}

// Test the decrypt function
console.log(decrypt('your_encrypted_string_here'));


Please note that you need to replace `'your_encrypted_string_here'` with the actual encrypted string you want to decrypt.

Also, this code uses the `crypto` module which is built-in in Node.js, so you don't need to install any additional packages.