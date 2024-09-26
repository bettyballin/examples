var sjcl = require("sjcl");

var out = sjcl.hash.sha1.hash("The quick brown fox jumps over the lazy dog");
var hash = sjcl.codec.hex.fromBits(out)

console.log(hash);