const fs = require('fs');
const pkcs12 = require('forge-pkcs12');

// Read the PFX/PKCS#12 file content.
const pfxContent = fs.readFileSync('/path/to/your/p12/file.p12', 'binary');

// Parse and extract certificates from PKCS#12 container.
const { certs } = pkcs12.pkcs12ToAsn1(pfxContent, '123456');
console.log(certs);