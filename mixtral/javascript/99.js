const EC = require('elliptic').ec;
const sss = require('shamirs-secret-sharing');

// Generate master secret key
let ec = new EC('secp256k1');
let sk = ec.genKeyPair();

// Split the private key into two shares
let threshold = 2;
let shareCount = 3;
const scheme = sss({
  threshold: threshold,
  parts: shareCount
});

var secretShares = scheme.split(sk.getPrivate().toString('hex'));

// Generate public keys for each share
for (i = 0; i < shareCount; ++i) {
  let share = secretShares[i];
  let shareSK = ec.keyFromPrivate(share, 'hex');
  let sharePK = shareSK.getPublic();
  console.log(`Share ${i+1} public key: ${sharePK.getEncoded().toString('hex')}`);
}