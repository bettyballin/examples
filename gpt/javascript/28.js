
// Create a typed array to hold the random values
var array = new Uint32Array(10);

// Fill the array with cryptographically secure random numbers
window.crypto.getRandomValues(array);

console.log(array);

