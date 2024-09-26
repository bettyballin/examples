(async () => {
  const jwks = require('jwks-rsa');
  const cert = await jwks.import('https://www.googleapis.com/oauth2/v1/certs', '859c1234d08e008cc261ff11de5f8da1b8c4d490');
  console.log(cert);
})();