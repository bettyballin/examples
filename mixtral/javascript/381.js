(async function() {
    const subtle = crypto.subtle;

    // Generate a 2048-bit RSA keypair
    const keyConfig = {
        name: "RSA-OAEP",
        modulusLength: 2048,
        publicExponent: new Uint8Array([1, 0, 1]),
        hash: "SHA-256"
    };

    // Generate the keypair
    const key = await subtle.generateKey(keyConfig, true, ["encrypt", "decrypt"]);

    // Extract public and private keys
    const publicKey = key.publicKey;

    try {
        // Export the RSA public key in SPKI format
        const exportedPublicKey = await subtle.exportKey("spki", publicKey);

        console.log(new Uint8Array(exportedPublicKey));

    } catch (err) {
        alert(`Error: ${err}`);
    }
})();