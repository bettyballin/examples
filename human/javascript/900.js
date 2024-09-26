var passphrase = new TextEncoder().encode('a sample passphrase');

// Import passphrase
window.crypto.subtle.importKey("raw", passphrase, { name: "PBKDF2" }, false, ["deriveBits"])
.then(function(passphraseImported){
    
    // Derive key as ArrayBuffer
    window.crypto.subtle.deriveBits(
        {
            name: "PBKDF2",
            hash: 'SHA-256',
            salt: new TextEncoder().encode('a sample salt'), 
            iterations: 10000
        },
        passphraseImported, 
        128 
    )  
    .then(function (bits) {
        console.log("raw key:", new Uint8Array(bits)); 
        
        // If necessary, import as CryptoKey, e.g. for encryption/decryption with AES-CBC
        window.crypto.subtle.importKey("raw", bits, { name: "AES-CBC" }, false, ["encrypt", "decrypt"])
        .then(function(cryptoKey){
            console.log("CryptoKey:", cryptoKey);
        });
    }); 
});