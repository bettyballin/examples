const sodium = require('sodium-native');

function signingKeypair() {
    const keypair = {
        publicKey: sodium.sodium_malloc(sodium.crypto_sign_PUBLICKEYBYTES),
        secretKey: sodium.sodium_malloc(sodium.crypto_sign_SECRETKEYBYTES)
    }
    sodium.crypto_sign_keypair(keypair.publicKey, keypair.secretKey)
    return keypair
}

const ed25519KeyPair = signingKeypair() 
const x25519KeyPair = {
    publicKey: sodium.sodium_malloc(sodium.crypto_box_PUBLICKEYBYTES),
    secretKey: sodium.sodium_malloc(sodium.crypto_box_SECRETKEYBYTES)
}
sodium.crypto_sign_ed25519_pk_to_curve25519(x25519KeyPair.publicKey, ed25519KeyPair.publicKey) 
sodium.crypto_sign_ed25519_sk_to_curve25519(x25519KeyPair.secretKey, ed25519KeyPair.secretKey) 
console.log(x25519KeyPair.publicKey.toString('hex'))
console.log(x25519KeyPair.secretKey.toString('hex'))