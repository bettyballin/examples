
function generateRandomString() {
    // Create a Uint8Array of 16 bytes
    const randomBytes = new Uint8Array(16);
    // Populate array with cryptographically strong random values
    window.crypto.getRandomValues(randomBytes);
    
    // Convert random bytes to string (similar to toString(36))
    let randomString = '';
    randomBytes.forEach(byte => {
        // Convert each byte to a base36 string and append it
        randomString += (byte % 36).toString(36);
    });
    
    // If you need a string of a specific length, trim or pad the result
    return randomString.substring(0, 26);
}

// Use the function
const myRandomString = generateRandomString();
