Here is the executable JavaScript code:



// Generate RSA-OAEP key pair
window.crypto.subtle.generateKey(
    {
        name: "RSA-OAEP",
        modulusLength: 2048,
        publicExponent: new Uint8Array([1, 0, 1]),
        hash: {name: "SHA-256"}
    },
    true,
    ["encrypt", "decrypt"]
)
.then(function(key){
    //returns the symmetric key
    console.log(key);
    const privateKey = key.privateKey;

    // Use provided password to encrypt private key
    const password = "mysecretpassword";
    const passwordBuffer = new TextEncoder().encode(password);

    // Encrypt private RSA-OAEP key using AES-GCM and password provided by user.
    window.crypto.subtle.importKey(
        'raw',
        passwordBuffer,
        {name: "AES-GCM"},
        false,
        ["encrypt", "decrypt"]
    )
    .then(function(key){
        return window.crypto.subtle.encrypt(
            {
                name: "AES-GCM",
                iv: window.crypto.getRandomValues(new Uint8Array(12)), //must be 12 bytes, you can re-use this value against the same password
                additionalData: new ArrayBuffer(0), //optional but must also use it during decryption
                tagLength: 128
            },
            key,
            privateKey //arrayBuffer of the data
        )
    })
    .then(function(encrypted){
        console.log(new Uint8Array(encrypted));
        const encryptedPrivateKey = encrypted;

        // Decrypt private RSA-OAEP key using AES-GCM and password provided by user.
        window.crypto.subtle.importKey(
            'raw',
            passwordBuffer,
            {name: "AES-GCM"},
            false,
            ["encrypt", "decrypt"]
        )
        .then(function(key){
            return window.crypto.subtle.decrypt(
                {
                    name: "AES-GCM",
                    iv: new Uint8Array(12), //same as before, must be 12 bytes
                    additionalData: new ArrayBuffer(0), //optional but the same value used during encryption
                    tagLength: 128
                },
                key,
                encryptedPrivateKey //arrayBuffer of the data
            )
        })
        .then(function(decrypted){
            console.log(new Uint8Array(decrypted));
        })
        .catch(function(err){
            console.error(err);
        });
    })
    .catch(function(err){
        console.error(err);
    });
})
.catch(function(err){
    console.error(err);
});