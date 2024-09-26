const forge = require('node-forge');

const der = "308..."; // Your DER certificate hex string

// Convert to bytes
let certDERBytes = forge.util.hexToBytes(der);

try {
  let p7cert = forge.asn1.fromDer(forge.asn1.decode(certDERBytes));

  // Extract the common name
  const subjectDN = forge.pki.oids['2.5.4.3'];

  if (Array.isArray(p7cert.subject)) {
    let cn = p7cert.subject
      .filter(({ type }) => type === subjectDN)
      .map(({ value: [{ set }] }) => forge.asn1.derToOid(set)[0])
      [0];

    console.log(`Common Name: ${cn}`);
  }
} catch (e) {
  // Handle error
  console.error(`Error parsing certificate: ${e}`);
}