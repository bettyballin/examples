csharp
using System;
using System.Security.Cryptography;
using Org.BouncyCastle.Asn1.X9;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Generators;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.Security;

class Program
{
    static void Main(string[] args)
    {
        ECKeyPairGenerator gen = new ECKeyPairGenerator("ECDH");
        SecureRandom secureRandom = new SecureRandom();
        X9ECParameters ecp = NistNamedCurves.GetByName("P-256");
        ECDomainParameters ecSpec = new ECDomainParameters(ecp.Curve, ecp.G, ecp.N, ecp.H, ecp.GetSeed());
        ECKeyGenerationParameters ecgp = new ECKeyGenerationParameters(ecSpec, secureRandom);
        gen.Init(ecgp);
        AsymmetricCipherKeyPair eckp = gen.GenerateKeyPair();

        ECPublicKeyParameters ecPub = (ECPublicKeyParameters)eckp.Public;
        ECPrivateKeyParameters ecPri = (ECPrivateKeyParameters)eckp.Private;

        byte[] publicKeyBytes = ecPub.Q.GetEncoded();

        Console.WriteLine(BitConverter.ToString(publicKeyBytes));
    }
}