
function cryptoFloat() {
    // Create a new array to hold the random values
    var array = new Uint32Array(1);
    // Populate the array with a cryptographically secure random number
    window.crypto.getRandomValues(array);

    // Convert the random Uint32 value to a float in the range [0, 1)
    // The maximum value of a Uint32 is 2^32 - 1, so we divide by 2^32 to get the range [0, 1)
    return array[0] / (0xFFFFFFFF + 1);
}

// Example usage
console.log(cryptoFloat()); // Outputs a cryptographically secure random float, e.g., 0.8083966837153522

