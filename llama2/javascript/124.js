async function deriveSecretKey(privateKey, publicKey) {
    let sharedKey = await window.crypto.subtle.deriveKey(
        {
            name: "ECDH",
            public: publicKey
        },
        privateKey,
        {
            name: "AES-GCM",
            length: 256
        },
        false,
        ["encrypt", "decrypt"]
    );
    let derivedKey = await window.crypto.subtle.deriveKey(
        {
            name: "HKDF",
            hash: {name: "SHA-256"},
            salt: new Uint8Array(0),
            info: new Uint8Array(0)
        },
        sharedKey,
        {
            name: "AES-GCM",
            length: 256
        },
        false,
        ["encrypt", "decrypt"]
    );
    return derivedKey;
}

// Generate a private and public key for testing
async function generateKeys() {
    let keyPair = await window.crypto.subtle.generateKey(
        {
            name: "ECDSA",
            namedCurve: "P-384"
        },
        true,
        ["sign", "verify"]
    );
    let privateKey = keyPair.privateKey;
    let publicKey = keyPair.publicKey;
    return {privateKey, publicKey};
}

// Run the function
generateKeys().then(({privateKey, publicKey}) => {
    deriveSecretKey(privateKey, publicKey).then(derivedKey => {
        console.log(derivedKey);
    });
});