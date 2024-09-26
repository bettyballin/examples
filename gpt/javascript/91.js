
const crypto = require('crypto');

function cryptoAES(sInput, sKey, bEncrypt) {
    return cryptoHelper('aes-128-ecb', sInput, sKey, bEncrypt);
}

function cryptoHelper(sAlgo, sInput, sKey, bEncrypt) {
    let result = "";
    const bKey = Buffer.from(sKey, 'hex');
    const bInput = Buffer
