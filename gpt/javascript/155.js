
const jose = require('node-jose');

let keyStore = jose.JWK.createKeyStore();

const plainText = 'The true sign of intelligence is not knowledge but imagination.';

// Generate a new key for encryption
keyStore.generate("oct", 256)
  .then(function(key) {
    // Create the JWE token
    return jose.JWE.createEncrypt({ format: 'compact' }, key)
     
