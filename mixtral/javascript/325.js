const asn1 = require('asn1js');

function spkiToRaw(spki) {
  const decodedSPKI = asn1.fromBER(Buffer.from(spki, 'base64'));

  // Extract the components of EC public key
  let xCoordinateHex = Buffer.from(decodedSPKI.sequence[0].octetString).toString('hex');
  if (xCoordinateHex.length % 2 !== 0) {
    xCoordinateHex = '0' + xCoordinateHex;
  }

  let yCoordinateHex = Buffer.from(decodedSPKI.sequence[1].octetString).toString('hex');
  if (yCoordinateHex.length % 2 !== 0) {
    yCoordinateHex = '0' + yCoordinateHex;
  }

  // Create raw key
  const publicKeyRaw = `3059301306072a8648ce3d020106082a8648ce3d0301070342${xCoordinateHex}00${yCoordinateHex}`;

  return Buffer.from(publicKeyRaw, 'hex').toString('base64');
}

// Test the function
const spki = "your_spki_string_in_base64"; // replace with your SPKI string
console.log(spkiToRaw(spki));