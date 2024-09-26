const crypto = require('crypto');

function getId() {
    const byArray2 = new Uint8Array(8);
    crypto.randomBytes(byArray2.length).copy(new Buffer.from(byArray2.buffer));
    return Array.from(byArray2); // or `return byArray2` if you prefer a typed array
}

console.log(getId());