const crypto = require('crypto');
const ec = require('elliptic').ec;

function generateKeyPairFromPassword(password) {
    const salt = crypto.randomBytes(32);

    // Derive a key from the password and salt
    let derivedKey;

    try {
        derivedKey = crypto.pbkdf2Sync(
            Buffer.from(password),
            salt,
            100000,
            64,
            'sha512'
        );

        // Use the first half of the key as private
        const privBuffer = derivedKey.slice(0, 32);

        // Generate a new keypair using this buffer
        const curve = ec.getCurveByName("secp256k1");
        const keyPair = ec.keyFromPrivate(privBuffer.toString('hex'), curve);

        return {
            publicKey: keyPair.getPublic().encode('hex'),
            privateKey: privBuffer.toString('hex')
        };

    } catch (err) {
        console.error(`Error generating keypair from password: ${err}`);

        throw new Error(
            "Failed to generate a secure encryption key."
        );
    }
}

// Example usage:
const password = "mysecretpassword";
const keyPair = generateKeyPairFromPassword(password);
console.log(keyPair);