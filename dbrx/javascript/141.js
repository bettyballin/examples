const encryptedData = new Uint8Array(32); // assuming 32 bytes (64 characters in hex)
for (let i = 0; i < 32; i++) {
  encryptedData[i] = Math.floor(Math.random() * 256);
}
const Buffer = require('buffer').Buffer;
console.log(Buffer.from(encryptedData).toString('hex')); // prints 64 characters long string