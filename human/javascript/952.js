// https://stackoverflow.com/a/40031979/9014097
function buf2hex(buffer) { 
    return Array.prototype.map.call(new Uint8Array(buffer), x => ('00' + x.toString(16)).slice(-2)).join('');
}

// Assuming sjcl is the Stanford JavaScript Crypto Library
let sjcl = require('sjcl');

// Assuming encryptedObject is a Uint8Array or ArrayBuffer
let encryptedObject = new Uint8Array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);

let bdata = sjcl.codec.hex.toBits(buf2hex(encryptedObject.buffer));
let ive = sjcl.codec.hex.toBits(buf2hex(new Uint8Array(12).buffer));

console.log(bdata);
console.log(ive);