// Define the goog namespace
const goog = {
  crypt: {}
};

// Define the stringToByteArray function
goog.crypt.stringToByteArray = function(str) {
  const bytes = [];
  for (let i = 0; i < str.length; i++) {
    bytes.push(str.charCodeAt(i));
  }
  return bytes;
};

// Define the base64 namespace
goog.crypt.base64 = {
  encodeByteArray: function(bytes) {
    const base64Chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/';
    let result = '';
    for (let i = 0; i < bytes.length; i += 3) {
      const b1 = bytes[i];
      const b2 = bytes[i + 1] || 0;
      const b3 = bytes[i + 2] || 0;
      const v1 = (b1 & 0xFF) << 16 | (b2 & 0xFF) << 8 | (b3 & 0xFF);
      result += base64Chars[(v1 >> 18) & 0x3F] + base64Chars[(v1 >> 12) & 0x3F] + base64Chars[(v1 >> 6) & 0x3F] + base64Chars[v1 & 0x3F];
    }
    return result;
  }
};

// Define the Hmac class
goog.crypt.Hmac = class {
  constructor(hasher, key) {
    this.hasher = hasher;
    this.key = key;
  }

  getHmac(data) {
    const hash = this.hasher.hash(data);
    return hash;
  }
};

// Define the Sha1 class
goog.crypt.Sha1 = class {
  constructor() {}

  hash(data) {
    const hash = new Uint32Array(5);
    const words = new Uint32Array(data.length / 4);
    for (let i = 0; i < data.length; i += 4) {
      words[i / 4] = (data[i] << 24) | (data[i + 1] << 16) | (data[i + 2] << 8) | data[i + 3];
    }
    for (let i = 0; i < words.length; i += 16) {
      let a = hash[0];
      let b = hash[1];
      let c = hash[2];
      let d = hash[3];
      let e = hash[4];
      for (let j = 0; j < 16; j++) {
        const w = words[i + j];
        const t = (((a << 5) - a) + b) ^ ((d & e) ^ (d & c) ^ (e & c));
        e = d;
        d = c;
        c = (b << 30) | (b >>> 2);
        b = a;
        a = t + w;
      }
      hash[0] += a;
      hash[1] += b;
      hash[2] += c;
      hash[3] += d;
      hash[4] += e;
    }
    return new Uint8Array(hash.buffer);
  }
};

// Define the forceUnicodeEncoding function
function forceUnicodeEncoding(str) {
  return str.split('').map(c => c.charCodeAt(0)).map(c => String.fromCharCode(c));
}

// The goog_crypto function
function goog_crypto(string_to_sign, secret) {
  const hmac = new goog.crypt.Hmac(new goog.crypt.Sha1(), goog.crypt.stringToByteArray(secret));
  return goog.crypt.base64.encodeByteArray(hmac.getHmac(forceUnicodeEncoding(string_to_sign)));
}

// Test the function
console.log(goog_crypto('Hello, World!', 'my_secret_key'));