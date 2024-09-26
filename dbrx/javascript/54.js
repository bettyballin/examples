function hexToBytes(hex) {
    const bytes = [];
    for (let i = 0; i < hex.length; i += 2) {
        bytes.push(parseInt(hex.substring(i, i + 2), 16));
    }
    return bytes;
}

function base64Encode(bytes) {
    const base64Chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/';
    let base64String = '';
    for (let i = 0; i < bytes.length; i += 3) {
        const b1 = bytes[i];
        const b2 = bytes[i + 1] || 0;
        const b3 = bytes[i + 2] || 0;
        base64String += base64Chars[b1 >> 2];
        base64String += base64Chars[((b1 & 3) << 4) | (b2 >> 4)];
        base64String += base64Chars[((b2 & 15) << 2) | (b3 >> 6)];
        base64String += base64Chars[b3 & 63];
    }
    // Add padding if necessary
    while (base64String.length % 4 !== 0) {
        base64String += '=';
    }
    return base64String;
}

const hexString = 'f8e3a1b6d2c7be5cf9ef4ed0df86eb98ee29ca96ab68ec99dd53ad81fe67a48';
const bytes = hexToBytes(hexString);
const base64String = base64Encode(bytes);
console.log(base64String);