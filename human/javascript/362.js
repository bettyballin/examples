const co = require('co');
const ossl = require('openssl-wrapper');

co(function*() {
  var derCert = new Buffer('...'); // binary DER certificate
  var pemCert = yield ossl.qExec('x509', derCert, { inform: 'der', outform: 'pem' });
  console.log(pemCert);
}).catch((err) => {
  console.error(err);
});