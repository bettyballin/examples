
    // Example using the Web Crypto API
    async function encryptToken(token, password) {
        const enc = new TextEncoder();
        const keyMaterial = await window.crypto.subtle.importKey(
            "raw",
            enc.encode(password),
            { name: "PBKDF2" },
            false,
            ["deriveKey"]
        );

        const key = await window.crypto.subtle.deriveKey(
            {
                "name": "PBKDF2",
                salt: enc.encode('your-salt-string'),
                iterations:
