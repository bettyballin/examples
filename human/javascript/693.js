const pemString = "-----BEGIN PUBLIC KEY-----\nMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDCnwiV6Opd+3TZf9N1z9GVhxtY\nnqWiFRIsqUOR/vXXge8hbhgm5ITKfZtvyO92Lk+5Tl1Qdrb+OfNcKmBHkGUEdBib\nXCNEXj7SOhQTBH0PnV++8+xJXoutsiJU9Z+sjMCFivbd5wgBizXcY8U9SQfYb+Iv\nNQ8FBL4nV8lMiwAp8QIDAQAB\n-----END PUBLIC KEY-----\n";

function loadPublicKey(stored) {
  const data = Buffer.from(stored, 'base64');
  return data;
}

function toBase64DER(pem) {
  return pem.substring(0, pem.lastIndexOf("\n")) //remove last \n
    .substring(pem.indexOf('\n') + 1) //remove first line
    .substring(0, pem.lastIndexOf("\n") + 1) //remove last line
    .replace("\n", ""); // remove all \n occurences
}

const base64 = toBase64DER(pemString);
const publicKey = loadPublicKey(base64);

console.log(publicKey.toString('hex'));