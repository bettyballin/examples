const { KMSClient, DecryptCommand } = require('@aws-sdk/client-kms');

// Initialize AWS KMS client
const kmsClient = new KMSClient({ region: 'your-region' });

// Use AES-GCM with the same settings as CryptoJS
const encryptedData = 'your-encrypted-data';

const decryptCommand = new DecryptCommand({
  CiphertextBlob: encryptedData,
  KeyId: 'your-key-id'
});

kmsClient.send(decryptCommand).then(data => {
  const decryptedData = data.Plaintext;
  console.log(decryptedData.toString());
}).catch(err => {
  console.error(err);
});