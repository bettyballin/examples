(async () => {
    await deriveKey();
})();

async function deriveKey() {

    //
    // Key import
    //
    var server_x509 =  `-----BEGIN PUBLIC KEY-----
                        MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAEd7fej9GYVI7Vt6x5B6XhruHvmE/rnzIj
                        HmpxP8PKfnfWgrJbyG2cgQc3mf9uusqk1FKImA86rx2+avK8+7xIK9wxuF3x2KQq
                        nxNp7bUBit3phyhp72Nt/QLXmZHcDKXL
                        -----END PUBLIC KEY-----`;
    var client_pkcs8 = `-----BEGIN PRIVATE KEY-----
                        MIG2AgEAMBAGByqGSM49AgEGBSuBBAAiBIGeMIGbAgEBBDBjr4EGktNtx+3xErsC
                        MzldruzzfAEEO8Oth1/3b8sNfrqRsAgMnB/oVy024I+15wOhZANiAASbTF7LLedW
                        dik6nH8JX8WeU0R1ZRlqq0EAZ/t+UrFcSOaVJSOx5jMJ3nrqwuk2DnobDqFwXH6t
                        ZMsZHh4NFZ+bCVeHJRqy4SCZvQFB/xcksF29p1v14XHYI/XKMGyLLx4=
                        -----END PRIVATE KEY-----`;

    var client_private_key = b64_to_ab(client_pkcs8.replace('-----BEGIN PRIVATE KEY-----', '').replace('-----END PRIVATE KEY-----', ''));
    var server_public_key = b64_to_ab(server_x509.replace('-----BEGIN PUBLIC KEY-----', '').replace('-----END PUBLIC KEY-----', ''));
    var privateKey = await window.crypto.subtle.importKey( 
        'pkcs8', 
        client_private_key,
        { name: "ECDH", namedCurve: "P-384" },
        true, 
        ["deriveKey", "deriveBits"] 
    );
    var publicKey = await window.crypto.subtle.importKey(
        "spki", 
        server_public_key,
        { name: "ECDH", namedCurve: "P-384" },
        true, 
        [] 
    );
    
    //
    // Determine shared secret
    //
    var sharedSecret = await window.crypto.subtle.deriveBits(
        { name: "ECDH", namedCurve: "P-384", public: publicKey },
        privateKey, 
        384 
    );
    console.log("Shared secret:\n", ab_to_b64(sharedSecret).replace(/(.{48})/g,'$1\n'));
    
    //
    // Derive key from shared secret via HKDF
    //
    var sharedSecretKey = await window.crypto.subtle.importKey(
        "raw", 
        sharedSecret, 
        { name: "HKDF" }, 
        false, 
        ["deriveKey", "deriveBits"]
    );
    var derived_key = await window.crypto.subtle.deriveBits(
        { name: "HKDF", hash: "SHA-256", salt: new Uint8Array([]), info: new Uint8Array([]) }, 
        sharedSecretKey, 
        256
    );
    console.log("Derived key:\n", ab_to_b64(derived_key).replace(/(.{48})/g,'$1\n'))
}; 

function b64_to_ab(base64_string){
    return Uint8Array.from(atob(base64_string), c => c.charCodeAt(0));
}

function ab_to_b64(arrayBuffer){
    return btoa(String.fromCharCode.apply(null, new Uint8Array(arrayBuffer)));
}