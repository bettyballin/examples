csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        // Generate a new RSA key pair
        RSACryptoServiceProvider key = new RSACryptoServiceProvider(2048);

        // Export the private key to XML
        string privateKeyXml = key.ToXmlString(true);

        // Round-trip the key to XML and back
        RSACryptoServiceProvider roundTrippedKey = new RSACryptoServiceProvider();
        roundTrippedKey.FromXmlString(privateKeyXml);
    }
}