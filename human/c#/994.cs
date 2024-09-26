csharp
using Org.BouncyCastle.Asn1.Sec;
using Org.BouncyCastle.Asn1.X9;
using Org.BouncyCastle.Crypto.Digests;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.Crypto.Signers;
using Org.BouncyCastle.Math;
using Org.BouncyCastle.Utilities.Encoders;
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string messageToSign = "sample";
        var digest = new SHA256Managed();
        byte[] messageHash = digest.ComputeHash(Encoding.UTF8.GetBytes(messageToSign));

        X9ECParameters x9Params = SecNamedCurves.GetByName("secp256r1");
        ECDomainParameters ecParams = new ECDomainParameters(x9Params.Curve, x9Params.G, x9Params.N, x9Params.H);
        ECPrivateKeyParameters privKey = new ECPrivateKeyParameters(new BigInteger(1, Hex.Decode("C9AFA9D845BA75166B5C215767B1D6934E50C3DB36E89B127B8A622B120F6721")), ecParams);
        ECDsaSigner signer = new ECDsaSigner(new HMacDsaKCalculator(new Sha256Digest()));
        signer.Init(true, privKey);
        var signature = signer.GenerateSignature(messageHash);

        Console.WriteLine(signature[0].ToString(16).ToUpper());
        Console.WriteLine(signature[1].ToString(16).ToUpper());
    }
}