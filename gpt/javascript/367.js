
function encryptWithAes256(messageToEncrypt, password) {
    // Generate a random 16 bytes salt
    var salt = CryptoJS.lib.WordArray.random(128 / 8);

    // Derive the key using PBKDF2 with HMAC-SHA512 and 256-bit key size
    var key = CryptoJS.PBKDF2(password, salt, {
        keySize: 256 / 32,
        iterations: 1000,
        hasher: CryptoJS.algo.SHA512
    });

    // Generate a random 16 bytes IV
    var iv = CryptoJS
