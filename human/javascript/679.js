function syncGenRSAKey() {
    // Your synchronous RSA key generation code here
    // For example:
    const crypto = require('crypto');
    const keyPair = crypto.generateKeyPairSync('rsa', {
        modulusLength: 2048,
        publicKeyEncoding: {
            type: 'spki',
            format: 'pem'
        },
        privateKeyEncoding: {
            type: 'pkcs8',
            format: 'pem',
            cipher: 'aes-256-cbc',
            passphrase: ''
        }
    });
    return keyPair;
}

function asyncGenRSAKey() {
    return new Promise((resolve, reject) => {
        resolve(syncGenRSAKey());
    });
}

// Example usage
asyncGenRSAKey().then(keyPair => {
    console.log(keyPair);
});