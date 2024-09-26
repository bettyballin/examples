window.crypto.subtle
    .importKey(
        'pkcs8',
        abPrivateKey,
        {
            name: 'ECDSA',
            namedCurve: 'P-256'
        },
        false,
        ['sign']
    )
    .then(function (privateKey) {
        // Use the private key for signing
        console.log(privateKey);
    })
    .catch(function (error) {
        console.error(error);
    });