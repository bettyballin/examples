const crypto = require('crypto');

const privateKey = '-----BEGIN RSA PRIVATE KEY-----\n' +
    'MIIEpAIBAAKCAQEAn1pMVSEDO4EPzQxKgAakFxRgMGiewWZFAktenWo5aMt/OIso\n' +
    '8ZF+aZh8gCgYEA9jRgfQvWowpemlaTqci9nKffWXSjNWw9n/4ygZoeX3FjVnjgj\n' +
    'v0QI9h0DcMgI0YBjUqZ+1yf7gVY0T0XvXAaWgDmVQm0BjIYzEJjD2FjeOMyQ\n' +
    '-----END RSA PRIVATE KEY-----';

const data = 'Hello, World!';

const sha1 = crypto.createHash('sha1');
sha1.update(data);
const hash = sha1.digest();

const signature = crypto.privateEncrypt({
  key: privateKey,
  padding: crypto.constants.RSA_PKCS1_PADDING
}, hash);

console.log(signature.toString('base64'));