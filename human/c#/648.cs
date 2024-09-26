csharp
using System;
using System.Security.Cryptography;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        var map = new Dictionary<string, string>
        {
            { "1.2.840.113549.1.1.5", "SHA1" },
            { "1.2.840.113549.1.1.11", "SHA256" },
            { "1.2.840.113549.1.1.12", "SHA384" },
            { "1.2.840.113549.1.1.13", "SHA512" }
        };

        var cert = new 
        {
            SignatureAlgorithm = new 
            {
                Value = "1.2.840.113549.1.1.11" // OID of SHA256 with RSA
            }
        };

        var hashAlgName = (string)map[cert.SignatureAlgorithm.Value];
        var hashAlg = HashAlgorithm.Create(hashAlgName);

        Console.WriteLine(hashAlgName);
        Console.WriteLine(hashAlg);
    }
}