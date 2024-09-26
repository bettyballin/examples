crypto.subtle.importKey(
    "spki",
    arrayBuffer,
    {
        name: "RSASSA-PKCS1-v1_5",
        hash: "SHA-256"
    },
    false, // extractable flag (not needed here)
    ["verify"]  // usage flags
).then(function(publicKey) {
    const cert = new X509Certificate(publicKey);
});