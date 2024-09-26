csharp
using System;
using System.Security.Cryptography;

public class Program
{
    public static void Main()
    {
        using (var ecdh = new ECDiffieHellmanCng(CngKey.Create(CngAlgorithm.ECDsaP256)))
        {
            Console.WriteLine(ecdh.Key.ExportParameters(CngKeyBlobFormat.GenericPublicBlob));
        }
    }
}