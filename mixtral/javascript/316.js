function encryptWithAes256(messageToEncrypt, encryptorKey) {
    // Generate random 16 bytes salt
    var salt = CryptoJS.lib.WordArray.random(128/8);

    // Derive key
    var keySize = 256;
    var iterations = 1000;

    if (CryptoJS.PBKDF2) {
        console.log("PBKDF2 is supported");

        try{
            var derivedKey = CryptoJS.PBKDF2(encryptorKey, salt, 
                { keySize: keySize/32, iterations: iterations });

           // Generate random 16 bytes init vector (iv)
           var iv = CryptoJS.lib.WordArray.random(128/8);

            console.log("Derived Key : " + derivedKey);

            var cipherText = CryptoJS.AES.encrypt(messageToEncrypt, derivedKey, { iv: iv });

            return cipherText.toString();
        } catch (e) {
            console.error("Error: ", e);
        }
    } else {
        console.log("PBKDF2 is not supported");
    }
}

// Example usage:
var messageToEncrypt = "Hello, World!";
var encryptorKey = "my_secret_key";
var encryptedMessage = encryptWithAes256(messageToEncrypt, encryptorKey);
console.log("Encrypted Message: ", encryptedMessage);