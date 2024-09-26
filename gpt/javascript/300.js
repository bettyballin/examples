
var crypto = require('crypto');

// The key and IV should be Buffers with the correct length.
// Base64 decode the key and IV before using them.
var key = Buffer.from('xNRxA48aNYd33PXaODSutRNFyCu4cAe/InKT/Rx+bw0=', 'base64');
var iv = Buffer.from('81dFxOpX7BPG1UpZQPcS6w==', 'base64');

function encrypt_token(data) {
    var cipher = crypto.createCipheriv('aes-256-cbc',
