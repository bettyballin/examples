const crypto = require('crypto');

// Client and server nonces
let clientNonce = "clientNonce";
let serverNonce = "serverNonce";

// Derive the secret key
let derivedKey = getDerivedKey(clientNonce, serverNonce);

function getDerivedKey(clientSecret, serverSeed) {
  // Concatenate client and server seeds
  let seed = clientSecret + serverSeed;

  // Create SHA1 hash object
  let hash = crypto.createHash('sha1');

  // Update hash object with seed
  hash.update(seed);

  // Get the digest of the hash object
  let digest = hash.digest();

  // Create SHA1 hash object for P_SHA1
  let pHash = crypto.createHash('sha1');

  // Update P_SHA1 hash object with digest
  pHash.update(digest);

  // Update P_SHA1 hash object with seed and digest again
  pHash.update(seed);
  pHash.update(digest);

  // Get the digest of the P_SHA1 hash object
  let pDigest = pHash.digest();

  // Get the derived key
  derivedKey = pDigest.slice(0, 20);

  return derivedKey;
}

// Create a new Hmac object
const hmac = crypto.createHmac('sha256', derivedKey);

// Data to sign
let bytesToSign = "dataToSign";

// Sign the data
hmac.update(bytesToSign);

// Get the digest of the Hmac object
let signature = hmac.digest('base64');

console.log(signature);