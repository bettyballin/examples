const {stringifyBigInts, unstringifyBigInts} = require("snarkjs/src/stringifybigint.js");

// Test the functions
const bigInt = 12345678901234567890n;
const stringifiedBigInt = stringifyBigInts(bigInt);
console.log(stringifiedBigInt);

const unstringifiedBigInt = unstringifyBigInts(stringifiedBigInt);
console.log(unstringifiedBigInt);