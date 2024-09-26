const crypto = require('crypto');

const myRsa2048PrivateKey = 'your_base64_encoded_private_key'; // replace with your base64 encoded private key
const encryptedAliceDHForBob = 'base64_encoded_encrypted_data'; // replace with base64 encoded encrypted data

const decodedMyRsa2048PrivateKey = Buffer.from(myRsa2048PrivateKey, 'base64');

let alicePublicKeyBase64DecryptedByBob = crypto.privateDecrypt({
  key: decodedMyRsa2048PrivateKey,
  padding: crypto.constants.RSA_PKCS1_OAEP_PADDING,
  oaepHash: 'sha256'
}, Buffer.from(encryptedAliceDHForBob, 'base64')).toString('base64');