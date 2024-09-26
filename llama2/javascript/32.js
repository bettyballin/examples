// Import jwcrypto library
const jwcrypto = require('jwcrypto');

// Define keys object with certificates
const keys = {
  '859c1234d08e008cc261ff11de5f8da1b8c4d490': '-----BEGIN CERTIFICATE-----  -----END CERTIFICATE-----',
  'ad2a50cb70c5da789ee26d05b8f621a99e81202e': '-----BEGIN CERTIFICATE-----  -----END CERTIFICATE-----'
};

// Create a new JWKSet instance with keys
const jwks = new jwcrypto.JWKSet(keys);

// Example usage:
console.log(jwks);