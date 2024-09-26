function generateSalt() {
    const saltBuffer = new Uint8Array(256);
    crypto.getRandomValues(saltBuffer);
    return saltBuffer.toString();
}

console.log(generateSalt());