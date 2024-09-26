const crypto = require('crypto')
const alice = crypto.createECDH('prime256v1')

// Alice's privateKey (generated previously)
const alicePrivateKey = '937cdd11062b612ff3cb3e4a3c183254b9728b4c8c3a64de799ed196b672734b'

// Bob's publicKey transmitted to Alice
const bobPublicKey = '04aeceba6ae783c9b705833c2fa8822281f47f6f36bc867e4d398fa7a744d4fc63a010cbce1e6c9ac8858ad376a24ee8551615560f01c8bb63c86335c046b18962'

// set Alice's private key (not needed if continuing from (1))
alice.setPrivateKey(alicePrivateKey, 'hex')

const sharedSecret = alice.computeSecret(bobPublicKey, 'hex', 'hex')
console.log(`sharedSecret: ${sharedSecret}`)