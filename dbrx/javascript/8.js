Here is the executable JavaScript code:


const crypto = require('crypto');

var testVector  = {
    plaintext: "The quick brown fox jumps over the lazy dog",
    iv: "3bbdce68b2736ed96972d56865ad82a2",
    key: "a891f95cc50bd872e8fcd96cf5030535e273c5210570b3dcfa7946873d167c57"
};

var blockSize = 16;
var paddedPlaintextLength = Math.ceil(testVector.plaintext.length / blockSize) * blockSize;

// Pad the plaintext with zeros
testVector.paddedPlaintext = Buffer.concat([
    Buffer.from(testVector.plaintext, 'utf8'),
    Buffer.alloc(paddedPlaintextLength - testVector.plaintext.length)
]);

var key  = Buffer.from(testVector.key, "hex");
var iv   = Buffer.from(testVector.iv, "hex");

// Create a Cipher object with padding enabled
const cipher = crypto.createCipheriv('aes-256-cbc', key, iv);
cipher.setAutoPadding(false);

cipher.update(testVector.paddedPlaintext);
let crypted = Buffer.concat([cipher.update(testVector.paddedPlaintext), cipher.final()]).toString("hex");
console.log(crypted);