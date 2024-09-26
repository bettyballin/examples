var sjcl = {
  codec: {
    utf8String: {
      toBits: function(str) {
        var out = [];
        for (var i = 0; i < str.length; i++) {
          out.push(str.charCodeAt(i));
        }
        return out;
      }
    },
    hex: {
      fromBits: function(arr) {
        var out = "";
        for (var i = 0; i < arr.length; i++) {
          out += ((arr[i] < 16 ? "0" : "") + arr[i].toString(16));
        }
        return out;
      }
    }
  },
  misc: {
    hmac: function(key, hash) {
      this.key = key;
      this.hash = hash;
      this.mac = function(data) {
        var hash = this.hash;
        var key = this.key;
        var blocksize = 64;
        var ipad = 0x36;
        var opad = 0x5c;
        var hashsize = 32;
        var keyblock = [];
        for (var i = 0; i < blocksize; i++) {
          keyblock.push(key[i] ^ ipad);
        }
        var block = keyblock.slice();
        for (var i = 0; i < data.length; i++) {
          block.push(data[i]);
        }
        var hashout = hash(block);
        var okeyblock = [];
        for (var i = 0; i < blocksize; i++) {
          okeyblock.push(key[i] ^ opad);
        }
        var oblock = okeyblock.slice();
        for (var i = 0; i < hashsize; i++) {
          oblock.push(hashout[i]);
        }
        return hash(oblock);
      };
    }
  },
  hash: {
    sha256: function(data) {
      var createHash = function() {
        var h0 = 0x6a09e667;
        var h1 = 0xbb67ae85;
        var h2 = 0x3c6ef372;
        var h3 = 0xa54ff53a;
        var h4 = 0x510e527f;
        var h5 = 0x9b05688c;
        var h6 = 0x1f83d9ab;
        var h7 = 0x5be0cd19;
        var message = data.slice();
        var roundConstant = [
          0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
          0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
          0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
          0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
          0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
          0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
          0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
          0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2
        ];
        var processMessage = function(message) {
          for (var i = 0; i < 64; i++) {
            if (i < 16) {
              message[i] = message[i];
            } else {
              message[i] = (rotr(message[i - 2], 17) ^ rotr(message[i - 2], 19) ^
                (message[i - 2] >>> 10)) ^ message[i - 15];
            }
            var T1 = (h0 >>> 0) + bsig1(h0, h1, h2) + (message[i] >>> 0) + (roundConstant[i] >>> 0);
            var T2 = bsig0(h4, h5, h6);
            h7 = (h6 >>> 0) + T1;
            h6 = (h5 >>> 0) + T2;
            h5 = (h4 >>> 0) + (h7 >>> 0);
            h4 = (h3 >>> 0) + (h6 >>> 0);
            h3 = (h2 >>> 0) + (h5 >>> 0);
            h2 = (h1 >>> 0) + (h4 >>> 0);
            h1 = (h0 >>> 0) + (h3 >>> 0);
            h0 = T1 + T2;
          }
        };
        var rotr = function(n, b) {
          return (n >>> b) | (n << (32 - b));
        };
        var bsig1 = function(x, y, z) {
          return ((x >>> 6) ^ (x >>> 11) ^ (x >>> 25)) ^
            ((y & z) ^ ((~y) & x));
        };
        var bsig0 = function(x, y, z) {
          return ((x >>> 2) ^ (x >>> 13) ^ (x >>> 22)) ^
            ((x & y) ^ (x & z) ^ (y & z));
        };
        message.push(0x80);
        while (message.length % 64 !== 56) {
          message.push(0x00);
        }
        for (var i = 0; i < 8; i++) {
          message.push(0x00);
        }
        message[message.length - 1] = data.length * 8;
        processMessage(message);
        var digest = [];
        for (var i = 0; i < 8; i++) {
          digest.push(h0 & 0xffffffff);
          digest.push(h1 & 0xffffffff);
          digest.push(h2 & 0xffffffff);
          digest.push(h3 & 0xffffffff);
          digest.push(h4 & 0xffffffff);
          digest.push(h5 & 0xffffffff);
          digest.push(h6 & 0xffffffff);
          digest.push(h7 & 0xffffffff);
        }
        return digest;
      };
      return createHash();
    }
  }
};

var key = sjcl.codec.utf8String.toBits("key");
var out = (new sjcl.misc.hmac(key, sjcl.hash.sha256)).mac(sjcl.codec.utf8String.toBits("The quick brown fox jumps over the lazy dog"));
var hmac = sjcl.codec.hex.fromBits(out);
console.log(hmac);