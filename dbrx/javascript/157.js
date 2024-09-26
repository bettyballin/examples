var crypto  = require('crypto');
var key  = Buffer.from('xNRxA48aNYd33PXaODSutRNFyCu4cAe/InKT/Rx+bw0=', 'base64');
var iv  = Buffer.from('81dFxOpX7BPG1UpZQPcS6w==', 'base64');

function encrypt_token(data) {
    var cipher  = crypto.createCipheriv('aes-256-cbc', key, iv);
    return cipher.update(data, 'binary', 'base64') + cipher.final('base64');
}

function decrypt_token(data) {
    var decipher  = crypto.createDecipheriv('aes-256-cbc', key, iv);
    return decipher.update(data, 'base64', 'binary') + decipher.final('binary');
}

var encrypted = encrypt_token('partnerId=1&operationId=30215&clientId=CDX12345&timestamp=1545735181');
console.log('NodeJS encrypt: ', encrypted);
console.log('NodeJS decrypt: ', decrypt_token(encrypted));