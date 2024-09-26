
// Generating a Uint32Array containing one cryptographically secure random number
const array = new Uint32Array(1);
window.crypto.getRandomValues(array);

console.log(array[0]); // This will be your secure random number

// If you need a random number within a specific range, you can do the following:
const min = 10; // Define the minimum value of the range
const max = 50; // Define the maximum value of the range

const secureRandomNumber = Math.floor((window.crypto.getRandomValues(new Uint32Array(1))[0] / (0xFFFFFFFF + 1)) * (max - min + 1)) + min;

console.log(secureRandomNumber); // This will be a secure random number between min and max

