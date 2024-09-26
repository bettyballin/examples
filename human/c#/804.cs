csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        var rsa = RSA.Create();
        rsa.ImportProtectedData(RSA.Create().ExportParameters(true), "password", DataProtectionScope.CurrentUser);
        var recipient = new RSAPKCS1EncryptionPadding(rsa);
        recipient.OaepHashAlgorithm = HashAlgorithmName.SHA1;
        Console.WriteLine(recipient.OaepHashAlgorithm);
    }
}