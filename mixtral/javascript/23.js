function getRandomIntInRange(min, max) {
    var range = (max - min + 1);

    // Generate a random number between zero and one less than a power of two
    let bytesNeeded = Math.ceil((Math.log2(range)) / 8);
    let rawRandomBits = new Uint8Array(bytesNeeded).map(() => window.crypto.getRandomValues(new Uint32Array(1))[0]);

    // Convert the random bits to a number between zero and one less than range
    let scaledAndShiftedValue = Number((rawRandomBits.reduce((acc, val) => acc * 256 + val, 0) / Math.pow(2, 8*bytesNeeded)).toPrecision(range));

    return min + (scaledAndShiftedValue % range);
}

console.log(getRandomIntInRange(1, 100));