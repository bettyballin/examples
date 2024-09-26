const crypto = require('crypto');
const fs = require('fs');

crypto.generateKeyPair(
    'rsa',
    {
        modulusLength: 2048,
        publicKeyEncoding: {
            type: 'spki',
            format: 'pem'
        },
        privateKeyEncoding: {
            type: 'pkcs1',
            format: 'pem'
        }
    },
    (err, publicKey, privateKey) => {
        if (err) throw err;
        fs.writeFileSync("/home/dev/priv.pem", privateKey);
        fs.writeFileSync("/home/dev/pub.pem", publicKey);
    }
);