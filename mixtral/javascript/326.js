const crypto = require('crypto');

function generateDHKeys() {
  return new Promise((resolve, reject) => {
    crypto.generateKeyPair('dh', {
      prime: 2048,
      generator: 2,
    }, (err, publicKey, privateKey) => {
      if (err) reject(err);
      else resolve({ publicKeyB64: publicKey.export({ type: 'spki', format: 'pem' }).toString('base64') });
    });
  });
}

function spkiToRaw(spkiB64) {
  const spkiBuffer = Buffer.from(spkiB64, 'base64');
  const raw = spkiBuffer.slice(spkiBuffer.indexOf('\x30') + 4);
  return raw.toString('base64');
}

async function main() {
  const { publicKeyB64 } = await generateDHKeys();
  const publicKeyB64_raw = spkiToRaw(publicKeyB64);
  console.log(publicKeyB64_raw);
}

main();