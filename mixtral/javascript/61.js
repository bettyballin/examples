const crypto = require('crypto');

function getRandomValues(array) {
  const bytesNeeded = array.byteLength;

  let generatedBytes = [];

  while (generatedBytes.length < bytesNeeded) {
    // Generate random values using NodeJS's built-in crypto module
    const randomBuffer = crypto.randomFillSync(new Uint8Array(bytesNeeded));

    for (let i = 0; i < randomBuffer.byteLength && generatedBytes.length < bytesNeeded; ++i) {
      // Add the byte to our array
      generatedBytes.push(randomBuffer[i]);
    }
  }

  return new Uint32Array(generatedBytes);
}

// Usage:
const myArray = getRandomValues(new ArrayBuffer(10));
console.log(`Generated random values: [${[...myArray]}]`);