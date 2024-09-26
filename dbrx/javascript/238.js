const crypto = window.crypto || window.msCrypto;
const TextEncoder = window.TextEncoder;
const TextDecoder = window.TextDecoder;
const btoa = window.btoa;
const atob = window.atob;

async function encrypt(data, secretKey) {
  const initializationVector = crypto.getRandomValues(new Uint8Array(12));
  const encodedData = new TextEncoder().encode(JSON.stringify(data));

  const encryptedBuffer = await crypto.subtle.encrypt(
    {
      name: "AES-GCM",
      iv: initializationVector,
      tagLength: 128,
    },
    secretKey,
    encodedData
  );

  return `${btoa(String.fromCharCode(...new Uint8Array(encryptedBuffer)))}.${btoa(String.fromCharCode(...initializationVector))}`;
}

async function decrypt(encryptedData, secretKey) {
  const [dataBase64, ivBase64] = encryptedData.split(".");
  const initializationVector = new Uint8Array(atob(ivBase64).split('').map(c => c.charCodeAt(0)));
  const _data = new Uint8Array(atob(dataBase64).split('').map(c => c.charCodeAt(0)));

  try {
    const decryptedBuffer = await crypto.subtle.decrypt(
      {
        name: "AES-GCM",
        iv: initializationVector,
        tagLength: 128,
      },
      secretKey,
      _data
    );

    return new TextDecoder().decode(new Uint8Array(decryptedBuffer));
  } catch (error) {
    console.error("Error decrypting data:", error);
    throw error;
  }
}

// Usage example
async function main() {
  const secretKey = await crypto.subtle.generateKey({
    name: "AES-GCM",
    length: 256,
  }, true, ["encrypt", "decrypt"]);

  const data = "Hello, World!";
  const encryptedData = await encrypt(data, secretKey);
  console.log("Encrypted data:", encryptedData);

  const decryptedData = await decrypt(encryptedData, secretKey);
  console.log("Decrypted data:", decryptedData);
}

main();