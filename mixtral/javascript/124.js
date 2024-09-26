const CryptoJS = require("crypto-js");

// Generate a random 256 bits (32 bytes) secret key
let privateKey = CryptoJS.lib.WordArray.random(32);

function encryptChallengeCode(challengeCode, privateKey) {
    return CryptoJS.AES.encrypt(
        challengeCode,
        privateKey
    ).toString();
}

// Example usage:
let challengeCode = "exampleChallengeCode";
let encrypted = encryptChallengeCode(challengeCode, privateKey);
console.log(encrypted);