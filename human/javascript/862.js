function encryptWithAes256(messageToEncrypt, encryptorKey){
    // Generate random 16 bytes salt
    var salt = CryptoJS.lib.WordArray.random(128/8);
    
    // Derive key
    var key = CryptoJS.PBKDF2(
        encryptorKey, 
        salt, 
        { keySize: 256/32, iterations: 1000, hasher: CryptoJS.algo.SHA512 }     // Apply SHA512
    );                                                                         
    console.log("derived key:\n" + key);
    
    // Generate random 16 bytes init vector (iv)
    var iv = CryptoJS.lib.WordArray.random(128/8);
    
    // Encrypt
    var cipherText = CryptoJS.AES.encrypt(messageToEncrypt, key, {iv: iv});
    
    // Concatenate
    var encryptedData = salt.clone().concat(iv).concat(cipherText.ciphertext);  // Concatenate on binary level
    var encryptedDataB64 = encryptedData.toString(CryptoJS.enc.Base64);         // Base64 encode the result
    console.log("aes encrypted text:\n", encryptedDataB64.replace(/(.{56})/g,'$1\n')); 
}

// Add the CryptoJS library
var CryptoJS = require("crypto-js");

encryptWithAes256('The quick brown fox jumps over the lazy dog', 'my passphrase');