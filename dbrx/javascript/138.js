const crypto = require('crypto');

// Your RSA 2048-bit base64 encoded keys
const myRsaPrivateKeyBase64 = '...'; // replace with your private key
const othersRsaPublicKeyBase64 = '...'; // replace with other party's public key

// Convert your private key from PEM to DER format (ASN.1)
const derFormatKeyBuffer = Buffer.from(myRsaPrivateKeyBase64, 'base64');
const privateKeyDer = crypto.createPrivateKey({
  key: derFormatKeyBuffer,
  type: 'pkcs8'
});

// Extract the prime number p and generator g
const { p, g } = privateKeyDer.asymmetricKeyType === 'rsa'
  ? {
    p: privateKeyDer.n.toString('hex'),
    g: '02' // Commonly used generator value for DH
  }
  : {
    p: privateKeyDer.prime,
    g: privateKeyDer.generator
  };

// Create a new Diffie-Hellman instance with the extracted parameters
const dh = crypto.createDiffieHellman(Buffer.from(p, 'hex'), Buffer.from(g, 'hex'));

// Generate your public key and convert it to BigInt for easier manipulation
const myPublicKeyBuffer = dh.generateKeys();
const myPublicKeyBigInt = BigInt(`0x${myPublicKeyBuffer.toString('hex')}`);

// Convert other party's RSA 2048-bit base64 encoded public key from PEM to DER format (ASN.1)
const othersRsaPublicKeyBase64DerFormatBuffer = Buffer.from(othersRsaPublicKeyBase64, 'base64');

// Create a new public key instance from the DER format buffer
const othersRsaPublicKey = crypto.createPublicKey({
  key: othersRsaPublicKeyBase64DerFormatBuffer,
  type: 'spki'
});

// Extract the public key parameters
const otherPartyPublicKeyBuffer = othersRsaPublicKey.export({
  type: 'spki',
  format: 'der'
});

// Convert the public key buffer to BigInt
const otherPartyPublicKeyBigInt = BigInt(`0x${otherPartyPublicKeyBuffer.toString('hex')}`);

// Compute the shared secret using BigInt and DH instance
const sharedSecretBuffer = dh.computeSecret(otherPartyPublicKeyBuffer);
const sharedSecretBigInt = BigInt(`0x${sharedSecretBuffer.toString('hex')}`);

console.log(sharedSecretBigInt.toString(16));