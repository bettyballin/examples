(async function() {
    const subtle = crypto.subtle;
    const keyConfig = {
        name: "RSA-OAEP",
        modulusLength: 2048,
        publicExponent: new Uint8Array([1, 0, 1]),
        hash: "SHA-256"
    };
    const key = await subtle.generateKey(keyConfig, true, ["encrypt", "decrypt"]);
    const publicKey = key.publicKey;

    try {
        const exportedPublicKey = await subtle.exportKey("spki", publicKey);
        console.log(exportedPublicKey);  // Log the exported public key
    } catch (err) {
        console.error(err);  // Log errors
    }
})();