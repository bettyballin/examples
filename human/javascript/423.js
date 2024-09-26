const RSAKey = require('rsa-key');

var sk = new RSAKey();
sk.setPrivate("a6d224de3d5a6c7c1a1a6e0e2c0a5a7a", "010001", "4c8f4e5d5c4e3d3c2c1a1a6e0e2c0a5a7a");
var plaintext = sk.decrypt("71938281431918241839201a1a6e0e2c0a5a7a");
console.log(plaintext);