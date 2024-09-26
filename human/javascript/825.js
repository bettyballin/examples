const nacl = require('tweetnacl');

var keyPair = nacl.sign.keyPair();
var secretKey  = keyPair.secretKey;
var publicKey = keyPair.publicKey;
var msgStr = "The quick brown fox jumps over the lazy dog";
var msg = nacl.util.decodeUTF8(msgStr);
var signature = nacl.sign(msg, secretKey);
var signatureB64 = nacl.util.encodeBase64(signature);
console.log(signatureB64.replace(/(.{64})/g,'$1\n')); // Display signature plus message (Base64 encoded)
var signatureMsgPart = signature.slice(64); 
console.log(nacl.util.encodeUTF8(signatureMsgPart));  // Display message from nacl.sign() return value: signing is not for encryption!
var verifiedMsg = nacl.sign.open(signature, publicKey);
console.log(nacl.util.encodeUTF8(verifiedMsg));       // Display message after successfull verification