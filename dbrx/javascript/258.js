// Import necessary libraries
const sjcl = require('sjcl');
const { TextDecoder } = require('util');

// Define the encrypted object (replace with your actual object)
let encryptedObject = [/* your encrypted object */];

// Define the code in a function to avoid no-unused-vars error
function main() {
  let bdata = sjcl.codec.base64.toBits(new TextDecoder().decode(new Uint8Array(encryptedObject)));
  console.log(bdata);
}

// Run the function
main();