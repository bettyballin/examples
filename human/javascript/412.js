const crypto = require('crypto');

const alice = crypto.createECDH('prime256v1');
alice.generateKeys()

const alicePublicKey = alice.getPublicKey('hex')
const alicePrivateKey = alice.getPrivateKey('hex')

console.log(`publicKey: ${alicePublicKey}`)
console.log(`privateKey: ${alicePrivateKey}`)


You can run this code in a Node.js environment. Save it to a file (e.g., `ecdh.js`) and run with `node ecdh.js` in your terminal.