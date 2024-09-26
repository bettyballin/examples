import crypto from "crypto";

const algorithm = 'aes256';
const inputEncoding = 'utf8';
const outputEncoding = 'hex';

export async function encryptObject(dataToEncrypt, key) {
  const salt = crypto.randomBytes(16);

  // Combine the original encryption key with a generated salt
  let combinedKey;

  if (typeof key === "string")
    combinedKey = crypto.scryptSync(key, salt, 32).toString("hex");

  else
    combinedKey = Buffer.concat([salt, key]).slice(0, 64);

  const iv = crypto.randomBytes(16);

  // Use the new combined encryption key
  const cipher = crypto.createCipheriv(algorithm, combinedKey, iv);

  let encryptedData = cipher.update(JSON.stringify(dataToEncrypt), inputEncoding, outputEncoding)

  return salt.toString("hex") + ":" + iv.toString("hex") + ":" + (encryptedData += cipher.final(outputEncoding));
}