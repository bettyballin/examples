csharp
using Windows.Security.Cryptography;
using Windows.Security.Cryptography.Core;
using Windows.Storage.Streams;

public class CryptographyExample
{
    public void DecryptData()
    {
        // Initialize the symmetric key
        SymmetricKey symetricKey = SymmetricKey.CreateNew(SymmetricAlgorithmNames.AesCbcPkcs7);

        // Initialize the buffer to decrypt
        IBuffer toDecryptBuffer = new Buffer(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 });

        // Decrypt the data
        IBuffer buffDecrypted = CryptographicEngine.Decrypt(symetricKey, toDecryptBuffer, null);

        // Do something with the decrypted data
        byte[] decryptedBytes = buffDecrypted.ToArray();
    }
}