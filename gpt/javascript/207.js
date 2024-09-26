
window.crypto.subtle.generateKey(
    {
        name: "ECDH",
        namedCurve: "P-256", // This corresponds to 'prime256v1' in Node.js
    },
    true, // Key is extractable
    ["deriveKey", "deriveBits"] // Usages
)
.then(function(keyPair){
    // Export the public key to a ArrayBuffer (which is similar to a Node Buffer)
    window.crypto.subtle.exportKey('raw', keyPair.publicKey)
    .then(function(exportedPublicKey) {
        // Handle the ArrayBuffer of the public key
        console.log(new Uint8Array(exportedPublicKey)); // Convert to Uint8Array if you want to work with bytes

        // You can also export the private key if necessary
        window.crypto.subtle.exportKey('pkcs8', keyPair.privateKey)
        .then(function(exported
