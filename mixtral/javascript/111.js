// Define namespaceBytes and name variables
let namespaceBytes = new Uint8Array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]);
let name = 'something';

// Combine namespaces with "something"
let combinedArray = new ArrayBuffer(namespaceBytes.byteLength + 8 /* length of 'something' */);
const view2 = new DataView(combinedArray);

for (var i = 0; i < 16; ++i) {
    view2.setUint8(i, namespaceBytes[i]);
}

// Convert 'something' to byte array
const nameBytes = new TextEncoder().encode(name);

for (var i = 0, j = 16; j < combinedArray.byteLength; j++, i++) {
    view2.setUint8(j, nameBytes[i]);
}

console.log(combinedArray);