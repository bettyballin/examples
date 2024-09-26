
window.crypto.subtle.generateKey(
    {
        name: "ECDSA",
        namedCurve: "P-256", //can be "P-256", "P-384", or "P-521"
    },
    true, //whether the key is extractable (i.e., can be used in exportKey)
    ["sign", "verify"] //can be any combination of "sign" and "verify"
)
.then(function(key) {
    return window.crypto.subtle.exportKey(
        "spki", //can be "jwk" (public or private), "spki" (public only), or "pkcs8" (private only)
        key.publicKey //can be a publicKey or privateKey, as long as extractable was true
    );
})
.then(function(keydata) {
    // Convert the ArrayBuffer to a
