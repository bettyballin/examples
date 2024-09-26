
const cryptojs = require('crypto-js');
const base32 = require('hi-base32');

function generateHOTP(secret, counter) {
   const decodedSecret = base32.decode.asBytes(secret);
   const secretWordArray = cryptojs.lib.WordArray.create(decodedSecret);
   const buffer = Buffer.alloc(8);
   for (let i = 0; i < 8; i++) {
      buffer[7 - i] = counter & 0xff;
      counter = counter >> 8;
   }

   // Step 1: Generate an HMAC-SHA-1 value using crypto-js
   let hmacjs = cryptojs.algo.HMAC.create(cryptojs.algo.SHA1, secretWordArray);
   const counterWordArray = cryptojs.lib.WordArray.create(buffer);
   hmacjs.update(counterWordArray);
   const hmacResult
