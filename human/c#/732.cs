csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        // Define the CSP parameters
        CspParameters csp = new CspParameters();
        csp.KeyContainerName = "MyKeyContainer";

        // Define the private key parameters
        RSAParameters privateKey = new RSAParameters();
        // Load your private key here, e.g. from a file or a database
        // For demonstration purposes, we'll generate a new key pair
        using (RSACryptoServiceProvider rsp = new RSACryptoServiceProvider(csp))
        {
            privateKey = rsp.ExportParameters(true);
        }

        // Define the ciphertext to decrypt
        byte[] cipherArr = new byte[] { /* Load your ciphertext here */ };

        // Create a new RSACryptoServiceProvider instance
        using (RSACryptoServiceProvider rsp = new RSACryptoServiceProvider(csp))
        {
            rsp.PersistKeyInCsp = false;
            rsp.ImportParameters(privateKey);

            // Decrypt the data
            var data = rsp.Decrypt(cipherArr, true);

            // Print the decrypted data
            Console.WriteLine(BitConverter.ToString(data));
        }
    }
}