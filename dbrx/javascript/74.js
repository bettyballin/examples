const crypto = require('crypto');

function randomFloat() {
    const buf = new Uint32Array(1);
    while(true) {
        let bytes = crypto.randomBytes(4);
        for (let i=0; i<bytes.length; ++i)
            buf[0] |= bytes[i] << 8*i;
        if (buf[0] <= Number.MAX_SAFE_INTEGER - Math.pow(2, 52)) break;
    }
    return buf[0] / Math.pow(2, 53);
}

console.log(randomFloat());