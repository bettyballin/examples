const hexString = "48656c6c6f20576f726c64"; // example hex string
const arrayBuffer = new Uint8Array(hexString.match(/.{2}/g).map(e => parseInt(e, 16))).buffer;
console.log(arrayBuffer);