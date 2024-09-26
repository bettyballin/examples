function convertBinaryToPem(binaryData, label) {
  let base64Cert = btoa(
    binaryData.reduce((data, byte) => data + String.fromCharCode(byte), '')
  );

  const pemCertificate = [
    `-----BEGIN ${label}-----`,
    ...base64Cert.match(/.{1,64}/g),
    `-----END ${label}-----`
  ].join('\n');

  return pemCertificate;
}

// Example usage:
const binaryData = new Uint8Array([/* your binary data here */]);
const label = 'CERTIFICATE';
console.log(convertBinaryToPem(binaryData, label));