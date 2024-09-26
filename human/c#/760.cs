csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;
using Org.BouncyCastle.Asn1;
using Org.BouncyCastle.Asn1.X9;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.OpenSsl;
using Org.BouncyCastle.Security;

class Program
{
    static void Main(string[] args)
    {
        // Generate a private key
        var curve = ECNamedCurveTable.GetByName("secp256r1");
        var domainParams = new ECDomainParameters(curve.Curve, curve.G, curve.N, curve.H, curve.GetSeed());
        var secureRandom = new SecureRandom();
        var privateKey = new ECPrivateKeyParameters(new BigInteger(256, secureRandom), domainParams);

        // Create private key structure
        int orderBitLength = privateKey.Parameters.N.BitLength;
        X962Parameters x962 = new X962Parameters(privateKey.PublicKeyParamSet);
        ECPrivateKeyStructure privKeyStruct = 
            new ECPrivateKeyStructure(orderBitLength, privateKey.D, privateKey.PublicKeyParamSet.GetEncoded(), x962);

        // Convert to PEM format
        string header = @"-----BEGIN EC PRIVATE KEY-----";
        string privKeyStr = Convert.ToBase64String(privKeyStruct.GetDerEncoded(), 
            Base64FormattingOptions.InsertLineBreaks);
        string tail = @"-----END EC PRIVATE KEY-----";

        // Write to file
        string path = @"c:\tmp\myprivkey.pem";
        using (TextWriter textWriter = new StreamWriter(path))
        {
            textWriter.WriteLine(header);
            textWriter.WriteLine(privKeyStr);
            textWriter.WriteLine(tail);
        }
    }
}