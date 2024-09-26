
window.crypto.subtle.generateKey(
    {
        name: "RSA-OAEP",
        modulusLength: 2048,
        publicExponent: new Uint8Array([1, 0, 1]),
        hash: "SHA-256",
    },
    true,
    ["encrypt", "decrypt"]
).then(keyPair => {
    window.crypto.subtle.exportKey(
        "spki", 
        keyPair.publicKey
    ).then(exportedPublicKey => {
        const publicKeyPem =
