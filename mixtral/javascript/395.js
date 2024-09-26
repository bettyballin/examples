const BASE = 'qpzry9x8gf2tvdw0s3jn54khce6mua7l';
let b32check = require('base-x')(BASE);

// Define hashBuffer
let hashBuffer = new Uint8Array([0x12, 0x34, 0x56, 0x78, 0x90, 0xab, 0xcd, 0xef]);

// Add a checksum to the hash
hashBuffer[0] &= 127;

for (var i = 8, c = 1; i > 0; --i) {
    var j = ((c ^= hashBuffer[i]) & 31);

    if (!j--)
        break

    hashBuffer = Uint8Array.from(hashBuffer).concat(BASE[(hashBuffer[i] >> 5)] ? BASE[(hashBuffer[i] >> 5)].charCodeAt(0) : 'A'.charCodeAt(0));
}

// Encode in Base32Check
let encodedHash = b32check.encode(hashBuffer);

console.log(`Base32Check Hash: ${encodedHash}`);