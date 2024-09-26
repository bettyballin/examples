async function getAesGcmSecret(password, salt = window.crypto.getRandomValues(new Uint8Array(16))) {
    const keyMaterial = await crypto.subtle.importKey(
        'raw',
        new TextEncoder().encode(password),
        'PBKDF2',
        false,
        ['deriveBits']
    );

    return await crypto.subtle.deriveKey({
        name: "AES-GCM",
        length: 128
    }, keyMaterial, {
        name: "PBKDF2",
        salt: salt,
        iterations: 50000
    }, false, ["encrypt"]);
}

// Call the function to make it executable
getAesGcmSecret("mysecretpassword").then(secret => console.log(secret));