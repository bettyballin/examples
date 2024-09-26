const CryptoJS = require('crypto-js');

let hash   = CryptoJS.SHA256('hello world');
let buffer = Buffer.from(hash.toString(CryptoJS.enc.Hex), 'hex');
let array  = new Uint8Array(buffer);

console.log(array);