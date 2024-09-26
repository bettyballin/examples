
// Assuming you have the private key object `cryptoKey` (from Web Crypto API) and your payload

async function signPayload(privateKey, payload) {
    const encoder = new TextEncoder();
    const data = encoder.encode(JSON.stringify(payload));
    const signature = await window.crypto.subtle.sign(
        {
            name: "ECDSA",
            hash: {name: "SHA-256"},
        },
        privateKey,
        data
    );
    return new Uint8Array(signature);
}

// You'll also need to export the public key to a format that Python can use
