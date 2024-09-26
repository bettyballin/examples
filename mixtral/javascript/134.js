// Define the key pair
let key = {
  privateKey: {},
  publicKey: {}
};

// Generate a new key pair
window.crypto.subtle.generateKey(
  {
    name: "RSASSA-PKCS1-v1_5",
    modulusLength: 2048,
    publicExponent: new Uint8Array([0x01, 0x00, 0x01]),
    hash: { name: "SHA-256" }
  },
  true,
  ["sign", "verify"]
).then(function(keyPair) {
  key.privateKey = keyPair.privateKey;
  key.publicKey = keyPair.publicKey;

  // Export the private key
  window.crypto.subtle
    .exportKey("raw", key.privateKey)
    .then(function(keydata) {
      var privateKey = new Uint8Array(keydata);
      console.log('Private Key: ' + arrayToHexString(privateKey));
    })
    .catch(function(err) {
      console.log(err);
    });

  // Export the public key
  window.crypto.subtle
    .exportKey("spki", key.publicKey)
    .then(function(keydata) {
      var publicKey = new Uint8Array(keydata);
      console.log('Public Key: ' + arrayToHexString(publicKey));
    })
    .catch(function(err) {
      console.log(err);
    });
});

// Helper function
var arrayToHexString = function(array) {
  return Array
    .from(new Uint8Array(array))
    .map((b) => b.toString(16).padStart(2, '0'))
    .join('');
};