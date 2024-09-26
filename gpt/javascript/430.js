
export async function encryptObject(dataToEncrypt: object, key: Buffer) {
  const iv = crypto.randomBytes(16); // Generate a new IV for each encryption
  const clear = JSON.stringify(dataToEncrypt);

  const cipher = crypto.createCipheriv(algorithm, key
