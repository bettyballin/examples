const jose = require('node-jose');

async function main() {
  const keystore = await jose.JWK.asKeyStore().load(require('./keystore.json'));

  // Encryption
  let encrypted = await jose.JWE.createEncrypt({
    format: 'compact',
    fields: {
      alg: 'RSA1_5'
    }
  }, keystore.get('key-id'))
    .update(`Hello World!`)
    .final();

  console.log(encrypted);
}

main().catch((error) => {
  console.error(error);
});