const crypto = require('crypto');

function getRandomFloat() {
  const bytes = crypto.randomBytes(6);
  let result = 0;
  for (let i = 0; i < bytes.length; ++i) {
    // Shift the previous bits to make room and add new byte's value.
    result = (result << 8) | bytes[i];
  }
  return result / Math.pow(2, 48); // Divide by max possible value for a 6-byte number
}

console.log(getRandomFloat());