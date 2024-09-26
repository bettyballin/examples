const CryptoJS = require('crypto-js');

// Generate random keys for demonstration purposes only!
let key = CryptoJS.lib.WordArray.random(16);
let iv = CryptoJS.lib.WordArray.random(16);

console.log(`Key: ${key.toString()}`);
console.log(`IV:  ${iv.toString()}`);

let message = "Message";
let encrypted = encrypt(message, key, iv);
console.log(`Encrypted: ${encrypted}`);

let decrypted = decrypt(encrypted, key, iv);
console.log(`Decrypted: ${decrypted}`);

function encrypt(data, secretKey, initVector) {
    let encJson = CryptoJS.AES.encrypt(JSON.stringify({ data: data }), secretKey, { 
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7,
        iv: initVector
    });

    return encJson.toString();
}

function decrypt(encryptedData, secretKey, initVector) {
    let decStr = CryptoJS.AES.decrypt(encryptedData, secretKey, { 
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7,
        iv: initVector
    });

    return JSON.parse(decStr.toString(CryptoJS.enc.Utf8)).data;
}