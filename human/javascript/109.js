const crypto = require('crypto');

class Verifier {
  constructor(algorithm) {
    this.algorithm = algorithm;
  }

  verify(publicKey, signature, encoding) {
    const verify = crypto.createVerify(this.algorithm);
    verify.update('Some data to sign', 'utf8');
    verify.end();

    const isValid = verify.verify(publicKey, signature, encoding);
    return isValid;
  }
}

const verifier = new Verifier('RSA-SHA256');
const publicKey = '-----BEGIN CERTIFICATE-----...-----END CERTIFICATE-----';
const signature = 'some_signature';

const result = verifier.verify(publicKey, signature, 'hex');
console.log(result);