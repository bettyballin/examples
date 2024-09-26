const crypto = require('crypto');

// Generate 10 cryptographically strong pseudo-random values.
let array = new Uint32Array(10);
for (let i = 0; i < array.length; ++i) {
    let value;
    do {
        // Get a random number between 1 and the maximum possible integer
        // that can be represented by an unsigned 32-bit integer inclusive.
        const maxPossibleValue = Math.pow(2, 32);
        value = crypto.randomInt(maxPossibleValue - 1) + 1;
    } while (value > Number.MAX_SAFE_INTEGER);

    array[i] = value;
}

console.log(array);