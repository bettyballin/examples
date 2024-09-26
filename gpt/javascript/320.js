
const encrypted_vendor = VENDOR.hmacSHA1("message", "secret");

// Split hex string into two-character byte representations for binary conversion
function splitHex(hexString) {
    let chunks = [];
    for (var i = 0, charsLength = hexString.length; i < charsLength; i += 2) {
        chunks.push(hexString.substring(i, i + 2));
    }
    return chunks; // Make sure to return the chunks array
}

// Convert hex characters to binary bytes
function hexToBytes(hexString) {
    let bytes = new Uint8Array(hexString.length / 2);
   
