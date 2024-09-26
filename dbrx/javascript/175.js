const sodium = require('libsodium-wrappers');

function encodeBase64(data) {
    return sodium.to_base64(sodium.encode_utf8(data));
}

function decodeBase64(data) {
    return sodium.decode_utf8(sodium.from_base64(data));
}

// Usage example:
const originalData = "Hello, World!";
const encodedData = encodeBase64(originalData);
const decodedData = decodeBase64(encodedData);

console.log("Original Data:", originalData);
console.log("Encoded Data:", encodedData);
console.log("Decoded Data:", decodedData);