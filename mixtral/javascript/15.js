const { JWK, KeySet } = require('jose/dist/node/cjs');
const fetch = require('node-fetch');

async function getGoogleKeys() {
  const response = await fetch("https://www.googleapis.com/oauth2/v3/certs");

  if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);

  let keys = {};

  for (const [kid, key] of Object.entries(await response.json())) {
    const jwkKey = JWK.asKey({
      kty: 'RSA',
      alg: 'RS256',
      e: Buffer.from(key.e, "base64url").toString("utf8"),
      n: Buffer.from(key.n, "base64url").toString("utf8"),
    });

    keys[kid] = jwkKey;
  }

  return new KeySet({
    keys
  })
}

getGoogleKeys().then(keySet => console.log(keySet));