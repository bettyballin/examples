const forge = require('node-forge');
const fs = require('fs');

const keyFile = fs.readFileSync("./gost.p12", 'binary');
const p12Asn1 = forge.asn1.fromDer(keyFile);

const p12 = forge.pkcs12.pkcs12FromAsn1(p12Asn1, '123456');

const bags = p12.getBags({bagType: forge.pki.oids.certBag});

const bag = bags[forge.pki.oids.certBag][0];

// convert to ASN.1, then DER, then PEM-encode
const msg = {
  type: 'CERTIFICATE',
  body: forge.asn1.toDer(bag.asn1).getBytes()
};
const pem = forge.pem.encode(msg);

console.log(pem);