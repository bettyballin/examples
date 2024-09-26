const crypto = require('crypto');

const algorithm = "aes256";
const inputEncoding = "utf8";
const outputEncoding = "hex";

async function encryptObject(dataToEncrypt, key) {
  const salt = crypto.randomBytes(16);
  const iv = crypto.randomBytes(16);

  // Derive a new encryption key using the original key and generated salt
  const derivedKey = await new Promise((resolve, reject) => {
    crypto.pbkdf2(key.toString("hex"), salt, 100000, 32, "sha256", (err, derivedKey) => {
      if (err) reject(err);
      resolve(derivedKey);
    });
  });

  const clear = JSON.stringify(dataToEncrypt);

  const cipher = crypto.createCipheriv(algorithm, Buffer.from(derivedKey), iv);
  let ciphered = cipher.update(clear, inputEncoding, outputEncoding);
  ciphered += cipher.final(outputEncoding);

  return salt.toString(outputEncoding) + ":" + iv.toString(outputEncoding) + ":" + ciphered;
}

// Test the function
const key = crypto.randomBytes(32);
const dataToEncrypt = { foo: "bar" };
encryptObject(dataToEncrypt, key).then((encrypted) => console.log(encrypted));