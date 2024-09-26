const bits = 2048;

// Generate a new private/public keypair
async function generateKeyPair() {
    return await window.crypto.subtle.generateKey(
        {
            name: "RSA-OAEP",
            modulusLength: bits,
            publicExponent: new Uint8Array([1, 0, 1]),
            hash: 'SHA-256'
        },
        true,
        ["encrypt", "decrypt"]
    );
}

// Generate the key pair
generateKeyPair().then(key => {
    // Export private and public keys
    window.crypto.subtle.exportKey("pkcs8", key.privateKey).then(privateKeyBuffer => {
        console.log(privateKeyBuffer);
    });
    window.crypto.subtle.exportKey("spki", key.publicKey).then(publicKeyBuffer => {
        console.log(publicKeyBuffer);
    });
});