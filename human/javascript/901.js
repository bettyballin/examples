var passphrase = new TextEncoder().encode('a sample passphrase');

// Import passphrase
window.crypto.subtle.importKey("raw", passphrase, { name: "PBKDF2" }, false, ["deriveKey"])
.then(function(passphraseImported){
    
    // Derive key as CryptoKey, e.g. for encryption/decryption with AES-CBC
    window.crypto.subtle.deriveKey(
        { 
            name: "PBKDF2", 
            hash: 'SHA-256', 
            salt: new TextEncoder().encode('a sample salt'), // fix for testing, otherwise window.crypto.getRandomValues(new Uint8Array(16)), 
            iterations: 10000 
        },
        passphraseImported,
        { name: 'AES-CBC', length: 128 },
        true,
        ["encrypt", "decrypt"]
    )
    .then(function(cryptoKey){
        console.log("CryptoKey:", cryptoKey);  
        
        // If necessary, export as ArrayBuffer
        window.crypto.subtle.exportKey("raw", cryptoKey).then(function (keyRaw) {                       
            console.log("raw key", new Uint8Array(keyRaw)); // 7, 167, 39, 145, 34, 48, 60, 159, 242, 209, 254, 79, 78, 150, 215, 88
        });
    });
}).catch(function(err){
    console.error(err);
});