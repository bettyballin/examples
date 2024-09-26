// Import the sjcl library
const sjcl = require('sjcl');

// Define the encryptedObject variable
let encryptedObject = new Uint8Array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]).buffer;

// Convert the encryptedObject to a sjcl bit array
let bdata = sjcl.codec.arrayBuffer.toBits(encryptedObject);

// Create a new Uint8Array with 12 elements and convert it to a sjcl bit array
let ive = sjcl.codec.arrayBuffer.toBits(new Uint8Array(12).buffer);

// Use the globalThis.console to avoid the error
globalThis.console.log(bdata, ive);