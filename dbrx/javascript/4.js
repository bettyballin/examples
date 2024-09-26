const crypto = require('crypto');

cryptoAES  = function (sInput, sKey, bEncrypt) {
    return cryptoFunc('aes-128-ecb', Buffer.from(sInput, 'hex'), Buffer.from(sKey, 'hex'), bEncrypt);
};

cryptoFunc  = function (sAlgo, bInput, bKey, bEncrypt) {
    var result;
    if (bEncrypt){
        const cipher = crypto.createCipheriv(sAlgo, bKey, null); // use createCipheriv for ECB mode
        cipher.setAutoPadding(false);
        result = cipher.update(bInput).toString('hex');
        result += cipher.final().toString('hex'); 
     }
    return result;
};

console.log(cryptoAES("0101010101010101", "000102030405060708090a0b0c0d0e0f", true));