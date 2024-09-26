
// Assuming 'encryptedBase64' is the Base64-encoded string you received from the server
var encryptedBase64 = "mfrpKm5k5YtGkX6rp9/Bmz+cCkcz5tiLKQcxmOpDUow=";
// Assuming 'base64Key' and 'base64Iv' are the Base64-encoded key and IV
var base64Key = "yourBase64EncodedKey";
var base64Iv = "yourBase64EncodedIv";

// Parse the Base64 encoded key and IV
var key = CryptoJS.enc.Base64.parse(base64Key);
var iv = CryptoJS.enc.Base64.parse(base64Iv);

// Parse the Base64 encoded data to a CipherParams object
var cipherParams = CryptoJS.lib.CipherParams.create({
    ciphertext
