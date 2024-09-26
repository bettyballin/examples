const binaryChunks = ['1010', '1100', '1111'];

const decoded = binaryChunks.map(byte => parseInt(byte, 16));

console.log(decoded);