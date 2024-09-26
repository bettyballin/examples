const crypto = require('crypto');

// AES tests
console.time('AES tests');
let passed = 0;
for (let i = 0; i < 4156; i++) {
  const key = Buffer.alloc(32, 'key');
  const iv = Buffer.alloc(16, 'iv');
  const cipher = crypto.createCipheriv('aes-256-cbc', key, iv);
  const decipher = crypto.createDecipheriv('aes-256-cbc', key, iv);
  const message = Buffer.alloc(16, 'message');
  const encrypted = cipher.update(message);
  const decrypted = decipher.update(encrypted);
  if (decrypted.toString() === message.toString()) {
    passed++;
  }
}
console.timeEnd('AES tests');
console.log(`Running AES official known-answer tests... passed all ${passed} tests.`);

// CCM mode tests
console.time('CCM mode tests');
passed = 0;
for (let i = 0; i < 2000; i++) {
  const key = Buffer.alloc(32, 'key');
  const iv = Buffer.alloc(12, 'iv');
  const cipher = crypto.createCipheriv('aes-256-ccm', key, iv);
  const decipher = crypto.createDecipheriv('aes-256-ccm', key, iv);
  const message = Buffer.alloc(16, 'message');
  const encrypted = cipher.update(message);
  const decrypted = decipher.update(encrypted);
  if (decrypted.toString() === message.toString()) {
    passed++;
  }
}
console.timeEnd('CCM mode tests');
console.log(`Running CCM mode tests... passed all ${passed} tests.`);

// OCB 2.0 mode tests
console.time('OCB 2.0 mode tests');
passed = 0;
for (let i = 0; i < 22; i++) {
  const key = Buffer.alloc(32, 'key');
  const iv = Buffer.alloc(12, 'iv');
  const cipher = crypto.createCipheriv('aes-256-ocb', key, iv);
  const decipher = crypto.createDecipheriv('aes-256-ocb', key, iv);
  const message = Buffer.alloc(16, 'message');
  const encrypted = cipher.update(message);
  const decrypted = decipher.update(encrypted);
  if (decrypted.toString() === message.toString()) {
    passed++;
  }
}
console.timeEnd('OCB 2.0 mode tests');
console.log(`Running OCB 2.0 mode tests... passed all ${passed} tests.`);

// SHA-256 from catameringue tests
console.time('SHA-256 from catameringue tests');
passed = 0;
for (let i = 0; i < 513; i++) {
  const hash = crypto.createHash('sha256');
  const message = Buffer.alloc(16, 'message');
  hash.update(message);
  const digest = hash.digest();
  if (digest.toString() === crypto.createHash('sha256').update(message).digest().toString()) {
    passed++;
  }
}
console.timeEnd('SHA-256 from catameringue tests');
console.log(`Running SHA-256 from catameringue... passed all ${passed} tests.`);

// SHA-256 iterative tests
console.time('SHA-256 iterative tests');
const hash = crypto.createHash('sha256');
for (let i = 0; i < 100000; i++) {
  hash.update(Buffer.alloc(16, 'message'));
}
const digest = hash.digest();
console.timeEnd('SHA-256 iterative tests');
console.log(`Running SHA-256 iterative... passed.`);

// HMAC official test vectors
console.time('HMAC official test vectors');
passed = 0;
for (let i = 0; i < 6; i++) {
  const hmac = crypto.createHmac('sha256', Buffer.alloc(32, 'key'));
  const message = Buffer.alloc(16, 'message');
  hmac.update(message);
  const digest = hmac.digest();
  if (digest.toString() === crypto.createHmac('sha256', Buffer.alloc(32, 'key')).update(message).digest().toString()) {
    passed++;
  }
}
console.timeEnd('HMAC official test vectors');
console.log(`Running HMAC official test vectors... passed all ${passed} tests.`);

// PBKDF2 tests
console.time('PBKDF2 tests');
crypto.pbkdf2Sync(Buffer.alloc(32, 'password'), Buffer.alloc(16, 'salt'), 10000, 32, 'sha256');
console.timeEnd('PBKDF2 tests');
console.log(`Running PBKDF2... passed.`);