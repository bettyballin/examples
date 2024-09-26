csharp
using System;
using System.Collections.Generic;
using System.Security.Cryptography;

public class PrivateKeyInfo
{
    public int Version { get; set; }
    public PrivateKeyAlgorithmIdentifier PrivateKeyAlgorithm { get; set; }
    public byte[] PrivateKey { get; set; }
    public Attributes Attributes { get; set; }

    public class PrivateKeyAlgorithmIdentifier
    {
        public string Algorithm { get; set; }
        public object Parameters { get; set; }
    }

    public class Attributes
    {
        public List<Attribute> AttributesSet { get; set; }

        public class Attribute
        {
            public string AttrType { get; set; }
            public object AttrValues { get; set; }
        }
    }
}

class Program
{
    static void Main()
    {
        var privateKeyInfo = new PrivateKeyInfo
        {
            Version = 1,
            PrivateKeyAlgorithm = new PrivateKeyInfo.PrivateKeyAlgorithmIdentifier
            {
                Algorithm = "1.2.840.113549.1.1.1", // RSA
                Parameters = null
            },
            PrivateKey = new byte[] { 0x01, 0x02, 0x03, 0x04 },
            Attributes = new PrivateKeyInfo.Attributes
            {
                AttributesSet = new List<PrivateKeyInfo.Attributes.Attribute>
                {
                    new PrivateKeyInfo.Attributes.Attribute
                    {
                        AttrType = "1.2.840.113549.1.9.3", // contentType
                        AttrValues = "1.2.840.113549.1.9.3.1" // data
                    }
                }
            }
        };

        var rsa = RSA.Create();
        rsa.ImportProtectedData("pfx", privateKeyInfo.PrivateKey, null, out _);
        var publicKey = rsa.ExportParameters(false);

        Console.WriteLine($"Public Key: {Convert.ToBase64String(publicKey.Modulus)}");
    }
}