const decoded = [1, 2, 3, 4, 5]; // example array
const uint8array = new Uint8Array(new ArrayBuffer(decoded.length));
for (let i=0; i<uint8array.length; ++i) {
  uint8array[i] = decoded[i];
}
console.log(uint8array);