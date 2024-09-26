csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        CryptoConfig.AddAlgorithm(typeof(RSAPKCS1SHA256SignatureDescription), @"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");
    }
}