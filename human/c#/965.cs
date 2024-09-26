csharp
using System;
using System.IO;
using Org.BouncyCastle.Asn1.X9;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.OpenSsl;
using Org.BouncyCastle.Security;

class Program
{
    static void Main(string[] args)
    {
        string pem = @"-----BEGIN EC PRIVATE KEY-----
        your_private_key_here
        -----END EC PRIVATE KEY-----";

        PemReader pr = new PemReader(new StringReader(pem));
        AsymmetricCipherKeyPair keyPair = (AsymmetricCipherKeyPair)pr.ReadObject();
        ECPrivateKeyParameters privateKeyParams = (ECPrivateKeyParameters)keyPair.Private;
        ECPublicKeyParameters publicKeyParams = (ECPublicKeyParameters)keyPair.Public;

        Console.WriteLine(privateKeyParams);
        Console.WriteLine(publicKeyParams);
    }
}