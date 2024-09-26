csharp
using System;
using System.IO;
using System.Security.Cryptography;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.OpenSsl;
using Org.BouncyCastle.Security;

class Program
{
    static void Main(string[] args)
    {
        DSACryptoServiceProvider dsa = new DSACryptoServiceProvider(1024);
        AsymmetricCipherKeyPair dsaKey = DotNetUtilities.GetDsaKeyPair(dsa);
        using (StreamWriter sw = new StreamWriter("dsa.pem"))
        {
            PemWriter pw = new PemWriter(sw);
            pw.WriteObject(dsaKey);
        }
    }
}