
(async function() {
    const subtle = crypto.subtle;
    const keyConfig = {
        name: "RSA-OAEP",
        modulusLength: 2048,
        publicExponent: new Uint8Array([1,0,1]),
        hash: "SHA-256"
    };
    const keyPair = await subtle.generateKey(keyConfig, true, ["encrypt", "decrypt"]);
    const publicKey = keyPair.publicKey;
    const privateKey = keyPair.privateKey;

    try {
        const exportedPublicKey = await subtle.exportKey("spki", publicKey);
        // Do something with the exported public key ArrayBuffer
        alert(exportedPublicKey);
    } catch (err) {
        alert(err);
    }
})();

