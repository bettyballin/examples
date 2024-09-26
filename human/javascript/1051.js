const cryptojs = require("crypto-js");
const crypto = require("crypto");

let decodedSecret = "your_secret_key_here";
let buffer = Buffer.from("your_message_here", "utf8");

let decodedSecretWA = cryptojs.enc.Latin1.parse(Buffer.from(decodedSecret).toString('latin1')); 
let bufferWA = cryptojs.enc.Latin1.parse(buffer.toString('latin1'));                            
let hmacjsWA = cryptojs.algo.HMAC.create(cryptojs.algo.SHA1, decodedSecretWA);
hmacjsWA.update(bufferWA);
let hmacResultjsWA = hmacjsWA.finalize();
const hmacResultjs = Buffer.from(hmacResultjsWA.toString(cryptojs.enc.Latin1), 'latin1'); 
console.log(hmacResultjs);