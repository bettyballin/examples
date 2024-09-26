const secret = [1, 2, 3, 4, 5, 6];
const data = [7, 8, 9, 10];

// msrcrypto
const algorithm = {
    name: 'HMAC',
    hash: {
        name: 'SHA-256'
    }
};
const jwkKey = {
    kty: "oct",
    alg: "HS256",
    k: msrCrypto.toBase64(secret),
    ext: true
};
msrCrypto.subtle.forceSync = 1;
msrCrypto.subtle.importKey("jwk", jwkKey, algorithm, true, ['sign', 'verify']).then(key => {
    msrCrypto.subtle.sign(algorithm, key, new Uint8Array(data)).then(hmac => {
        const arr = new Uint8Array(hmac);
        console.log('msrCrypto: ' + msrCrypto.toBase64(arr));
    });
});

// cryptojs
const cryptoJsSecret = CryptoJS.lib.WordArray.create(secret);
const cryptoJsData = CryptoJS.lib.WordArray.create(data);
const hash = CryptoJS.HmacSHA256(cryptoJsData, cryptoJsSecret);
console.log('CryptoJS: ' + CryptoJS.enc.Base64.stringify(hash));