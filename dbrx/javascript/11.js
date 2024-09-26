const jwcrypto = require('jwcrypto');

// assuming googleCertsJwk is a valid JSON Web Key
const googleCertsJwk = {
  "kty": "RSA",
  "kid": "some-key-id",
  "n": "some-modulus",
  "e": "some-exponent"
};

const token = "some-token-to-verify";

const keyObj = jwcrypto.loadPublicKey(googleCertsJwk);
jwcrypto.verify(token, keyObj).then((result) => {
  console.log(result); // true if token is valid else false.
});