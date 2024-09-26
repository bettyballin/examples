
function generateSecureRandomASCIIString(length) {
    const validCharCodes = Array.from({ length: 95 }, (_, i) => i + 32);
    let array = new Uint8Array(length);
    window.crypto.getRandomValues(array);
    let result = '';
    for (let i = 0; i < array.length; i++) {
        result += String.fromCharCode(validCharCodes[array[i] % validCharCodes.length]);
    }
    return result;
}

// Example usage:
const nonce = generateSecureRandomASCIIString(16);
console.log(nonce);

