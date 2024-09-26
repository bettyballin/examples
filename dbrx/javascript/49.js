const jose = require('node-jose');

async function main() {
  // Generate random key for encryption/decryption
  let key = await jose.JWK.createKey('oct', 256);

  // Encrypt the payload with JWE
  let jwe = await jose.JWE.createEncrypt({ format: 'compact', key })
    .update(JSON.stringify({ "foo": "bar" }))
    .final();

  console.log(jwe);
}

main();