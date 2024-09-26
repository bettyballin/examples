const cryptojs = require("crypto-js");
const hmacjs = cryptojs.algo.HMAC.create("md5", "secretKey");

let bufferCryptoJS = [];
let counter = 0x1234567890abcdef;

for (let i = 0; i < 8; i++) {
    const byteValue = counter & 0xff;

    // Convert to WordArray
    bufferCryptoJS.push(byteValue);

    counter >>= 8;
}

let buffer = new Uint8Array(bufferCryptoJS);
let bufferWordArray = cryptojs.lib.WordArray.create([...buffer]);

hmacjs.update(bufferWordArray);