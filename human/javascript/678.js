function syncGenRSAKey() {
    const crypto = require('crypto');
    const generatedKey = crypto.generateKeyPairSync('rsa', {
        modulusLength: 2048,
        publicExponent: 65537,
        publicKeyEncoding: {
            type: 'spki',
            format: 'pem'
        },
        privateKeyEncoding: {
            type: 'pkcs8',
            format: 'pem'
        }
    });
    return generatedKey;
}

console.log(syncGenRSAKey());