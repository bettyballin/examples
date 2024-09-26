const crypto = require('crypto');

function getId(length) {
  const buf = new Uint8Array(length);

  // Fill buffer with random bytes
  crypto.randomFillSync(buf);

  return [...buf].map(b => b.toString(16).padStart(2, '0')).join('');
}

console.log(`Generated ID: ${getId(4)}`);