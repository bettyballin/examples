const crypto = require('crypto');

// Encrypt
function encrypt(data) {
  const algorithm = 'aes-256-cbc';
  let key = Buffer.from("your_secret_key", "hex");

  // Create a random initialization vector
  var iv = crypto.randomBytes(16);

  // Encrypt the data
  let cipher = crypto.createCipheriv(algorithm, key, iv);

  return {
    iv: iv.toString("hex"),
    encrypted: Buffer.concat([cipher.update(data), cipher.final()]).toString("hex")
  };
}

// Decrypt
function decrypt(iv, encryptedData) {
  const algorithm = 'aes-256-cbc';
  let key = Buffer.from("your_secret_key", "hex");
  iv = Buffer.from(iv, "hex");

  try {
    let decipher = crypto.createDecipheriv(algorithm, key, iv);

    return {
      data: Buffer.concat([decipher.update(Buffer.from(encryptedData, "hex")), decipher.final()]).toString()
    };
  } catch (err) {
    console.log("Decryption failed");
  }
}

// Usage
let enc = encrypt('Hello World');
console.log(`Encoded: ${enc.encrypted}`);

const encodedData = Buffer.from(enc.encrypted, "hex").toString('base64');
console.log(`Base64 Encoding: ${encodedData}`);

// Decode
let dec = decrypt(enc.iv, enc.encrypted);
console.log(`Decoded: ${dec.data}`);