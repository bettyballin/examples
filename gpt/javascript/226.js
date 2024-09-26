
var forge = require('node-forge');
var fs = require('fs');

// Read the P12 file
var p12File = fs.readFileSync('/path/to/p12/file.p12', 'binary');
var p12Asn1 = forge.asn1.fromDer(p12File);

// Decrypt the P12 file using the password
var p12 = forge.pkcs12.pkcs12FromAsn1(p12Asn1, '123456');

// Get the certificate bags (assuming there's at least one)
var certBags = p12.getBags({bagType: forge.pki.oids.certBag});
var certBag = certBags[forge.pki.oids.certBag][0];

// Get the X.509 certificate
if(certBag) {
    var cert = certBag.cert
