var forge = require('node-forge');
var fs   = require('fs');

// Read the PFX file
var pfxData  = forge.util.createBuffer(fs.readFileSync('/path/to/p12file'));

// Decrypt PKCS#12 data
var key     = 'password';
var keypair = forge.pkcs12.decryptRsaPrivateKey(key, pfxData);

// Extract the certificate
var certBag  = forge.asn1.derToOids(pfxData)[0];
var derCert  = forge.util.createBuffer(certBag[forge.oids.pkcs8ShroudedKeyBag].valueBlock.valueHex);

// Decode the certificate
var cert     = forge.pki.certificateFromAsn1(derCert, true);

console.log('Certificate:', cert.subject.attributes);