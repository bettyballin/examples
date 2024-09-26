const nacl = require('tweetnacl');

let message = "This is my unencrypted message"
let naclPair = nacl.sign.keyPair()
let signedMessage = nacl.sign(nacl.util.decodeUTF8(message), naclPair.secretKey)
let decrypted = nacl.sign.open(signedMessage, naclPair.publicKey)
console.log(nacl.util.encodeUTF8(decrypted))