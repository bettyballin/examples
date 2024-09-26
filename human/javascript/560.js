const fs = require('fs');
const pem = require('pem');

const pfx = fs.readFileSync("cert.pfx");

pem.readPkcs12(pfx, { p12Password: "test123" }, (err, cert) => {
  if(err) return console.log(err);
  let privateKey = b64ToBinary(removePFXComments(cert.key));
  let certificate = removePFXComments(cert.cert);
});

function b64ToBinary(b64String) {
  return Buffer.from(b64String, 'base64');
}

function removePFXComments(pfxString) {
  return pfxString.replace(/-----.*-----/g, '');
}