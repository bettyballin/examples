const forge = require('node-forge');

async function createSignature(requestBase64Url, keys) {
  let messageDigest = forge.md.sha256.create();
  messageDigest.update(`${requestBase64Url.protected}.${requestBase64Url.payload}`, 'utf8');
  const accountKey = await forge.pki.privateKeyFromPem(keys.accountKey.privatePem);
  let signature = accountKey.sign(messageDigest, {
    md: forge.md.sha256.create()
  });
  requestBase64Url.signature = String.fromCharCode.apply(null, new Uint8Array(forge.util.encode64(signature)));
  return requestBase64Url;
}

// Example usage:
let requestBase64Url = {
  protected: 'exampleProtected',
  payload: 'examplePayload'
};
let keys = {
  accountKey: {
    privatePem: 'yourPrivateKeyInPEMformat'
  }
};

createSignature(requestBase64Url, keys).then((result) => {
  console.log(result);
});