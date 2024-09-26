const sjcl = require('sjcl');
const crypto = require('crypto');

function eciesKeyDerivation(input) {
  const sha512 = crypto.createHash('sha512');
  return Buffer.from(sha512.update(Buffer.from(input)).digest());
}

// Generate key pairs for both parties (using secp256k1 curve)
const myPrivateKey = sjcl.ecc.curves.k256.generateKeys();
const recipientPublicKey = new sjcl.ecc.ecdsa.publicKey(
  sjcl.ecc.curves.k256,
  'recipient_public_key_hex'
);

// Compute shared secret
const sharedSecret = eciesKeyDerivation(
  myPrivateKey.dh(recipientPublicKey).get().toString()
);

// Example usage
console.log(sharedSecret.toString('hex'));