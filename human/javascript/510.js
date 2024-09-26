var CryptoJS = require("crypto-js");

const crypted = CryptoJS.enc.Base64.parse("8Z3dZzqn05FmiuBLowExK0CAbs4TY2GorC2dDPVlsn/tP+VuJGePqIMv1uSaVErr");

console.log(crypted.toString());