
window.crypto.subtle.generateKey(
    {
        name: "RSA-OAEP",
        modulusLength: 2048, // Can be 1024, 2048, or 4096
        publicExponent: new Uint8Array([1, 0, 1]), // 65537
        hash: {name: "SHA-256"} // Can be "SHA-1", "SHA-256", "SHA-384", or "SHA-512"
    },
    true, // Whether the key is extractable (i.e. can be used in exportKey)
    ["encrypt", "decrypt"] // Must be ["encrypt", "decrypt"] or ["wrapKey", "unwrapKey"]
).then(keyPair => {
    // Export the public key to a PEM format
    window.crypto.subtle.exportKey
