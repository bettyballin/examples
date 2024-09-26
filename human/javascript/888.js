const crypto = require('crypto');
const Buffer = require('buffer').Buffer;

// Convert the SPKI key of the WebCrypto side into the raw format
var webcryptoSpkiB64 = 'MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEPF2r2yyMp/PykPZEt6v8WFAvnrf5FsI3UnpEYsbKo7UKVKB8k2hfxxhjKw8p9nulNaRo472hTcEqsSbsGcr5Dg==';
var webcryptoRawB64 = Buffer.from(webcryptoSpkiB64, 'base64').slice(-65).toString('base64'); // the last 65 bytes

// Function to generate Diffie-Hellman keys
function generateDHKeys(webcryptoRawB64) {
  const alice = crypto.createDiffieHellman(2048);
  const aliceKey = alice.generateKeys();
  const bob = crypto.createDiffieHellman(aliceKey);
  const bobKey = bob.generateKeys();
  const sharedSecret = alice.computeSecret(bobKey);
  const sharedSecretHash = crypto.createHash('sha256').update(sharedSecret).digest();

  return {
    publicKeyB64: aliceKey.toString('base64'),
    privateKeyB64: alice.getPrivateKey().toString('base64'),
    sharedSecretB64: sharedSecret.toString('base64'),
    sharedSecretHashB64: sharedSecretHash.toString('base64')
  };
}

// Calculate the shared secret for the NodeJS side
var { publicKeyB64, privateKeyB64, sharedSecretB64, sharedSecretHashB64 } = generateDHKeys(webcryptoRawB64);

// Convert the raw key of the NodeJS side into the SPKI format 
var nodejsSpkiB64 = Buffer.concat([
  Buffer.from(webcryptoSpkiB64, 'base64').slice(0, -65), // all bytes except the last 65
  Buffer.from(publicKeyB64, 'base64')]
).toString('base64');

console.log("Shared secret:", sharedSecretB64);
console.log("SPKI:", nodejsSpkiB64); // will be sent to the WebCrypto side and used there to calculate the shared secret