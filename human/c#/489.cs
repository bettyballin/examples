csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        byte[] key = new byte[] { /* your private key bytes here */ };
        CngKey cngKey = CngKey.Import(key, CngKeyBlobFormat.EccPrivateBlob);
    }
}