const crypto = require('crypto');

function randomFloat() {
    const buf = new Uint32Array(1);
    while(true) {
        crypto.randomFillSync(buf, 0, 4);
        if (buf[0] <= Number.MAX_SAFE_INTEGER - Math.pow(2, 52)) break;
    }
    return buf[0] / Math.pow(2, 53);
}

console.log(randomFloat());