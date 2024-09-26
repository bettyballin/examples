const forge = require('node-forge');
const Buffer = require('buffer').Buffer;

// assuming accountKey and messageDigest are defined elsewhere in the code
const accountKey = /* your account key */;
const messageDigest = /* your message digest */;

const signature = accountKey.sign(messageDigest);
const decodedSignature = forge.util.binary.raw.decode(signature);
request.signature = Buffer.from(decodedSignature);