const jose = require('node-jose');

async function main() {

    const keystore = await jose.JWK.asKeyStore().load(require('./keystore.json'));

  // Decryption

  let decrypted = await jose.JWE.createDecrypt({ format: 'compact', key: keystore })
      .decrypt(`eyJhbGciOiAiUlMyNTYifQ..wKXqr...`)

    console.log(await decrypted.plaintext.toString());
}

main().catch((error) => {
  console.error(error);
});