
const crypto = require('crypto');

function generateRandomModPowerOfTen(powerOfTen, callback) {
  // Calculate the number of digits
  const digits = Math.log10(powerOfTen);

  // Check if powerOfTen is a power of 10
  if (!Number.isInteger(digits)) {
    return callback(new Error("Number is not a power of 10"), null);
  }

  // Calculate the number of bytes needed to cover the range
  const bytesNeeded = Math.ceil(digits / Math.log2(256));

  crypto.randomBytes(bytesNeeded, (err, buffer) => {
    if (err) {
      return callback(err, null);
    }

    let randomNumber = 0;
    for (let i = 0; i < bytesNeeded; i++) {
      randomNumber = (randomNumber * 256)
