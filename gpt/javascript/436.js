
crypto.generateKeyPair(
    "rsa",
    {
        modulusLength: 2048, // 1024-bit keys are considered weak; use at least 2048
        publicKeyEncoding: {
            type: "spki", // Change to "spki" for X.509 SubjectPublicKeyInfo format
            format: "pem",
        },
        privateKeyEncoding: {
            type: "pkcs8", // Use "pkcs8" for the private key encoding
            format: "pem",
        },
    },
    (err, publicKey,
