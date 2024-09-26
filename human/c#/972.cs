csharp
using Org.BouncyCastle.Asn1.Nist;
using Org.BouncyCastle.Asn1.Sec;
using Org.BouncyCastle.Asn1.X9;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.Math;
using Org.BouncyCastle.Security;
using Org.BouncyCastle.Utilities.Encoders;
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        using (var ecdhAlice = new ECDiffieHellmanCng())
        using (var ecdhBob = new ECDiffieHellmanCng())
        {
            // Generate Alice's private and public key
            ecdhAlice.HashAlgorithm = CngAlgorithm.Sha256;
            ecdhAlice.KeyDerivationFunction = ECDiffieHellmanKeyDerivationFunction.Hash;
            ecdhAlice.GenerateKey(ECCurve.NamedCurves.nistP256);
            byte[] privateKeyAlice = ecdhAlice.ExportParameters(true).D;
            ECPoint publicKeyAlice = ecdhAlice.ExportParameters(false).Q;

            // Generate Bob's private and public key
            ecdhBob.HashAlgorithm = CngAlgorithm.Sha256;
            ecdhBob.KeyDerivationFunction = ECDiffieHellmanKeyDerivationFunction.Hash;
            ecdhBob.GenerateKey(ECCurve.NamedCurves.nistP256);
            byte[] privateKeyBob = ecdhBob.ExportParameters(true).D;
            ECPoint publicKeyBob = ecdhBob.ExportParameters(false).Q;

            // Alice's key agreement
            byte[] keyAgreementAlice = GetKeyAgreementBC(NistNamedCurves.GetByName("P-256"), publicKeyBob, privateKeyAlice);
            byte[] keyAgreementSHA256Alice = SHA256.Create().ComputeHash(keyAgreementAlice);
            byte[] keyAgreementCngAlice = ecdhAlice.DeriveKeyMaterial(ecdhBob.PublicKey);
            Console.WriteLine("Alice's raw key agreement (BC):        " + Hex.ToHexString(keyAgreementAlice));
            Console.WriteLine("Alice's hashed key agreement (BC):     " + Hex.ToHexString(keyAgreementSHA256Alice));
            Console.WriteLine("Alice's key agreement (.NET):          " + Hex.ToHexString(keyAgreementCngAlice));
            Console.WriteLine();

            // Bob's key agreement
            byte[] keyAgreementBob = GetKeyAgreementExplicit(NistNamedCurves.GetByName("P-256"), publicKeyAlice, privateKeyBob);
            byte[] keyAgreementSHA256Bob = SHA256.Create().ComputeHash(keyAgreementBob);
            byte[] keyAgreementCngBob = ecdhBob.DeriveKeyMaterial(ecdhAlice.PublicKey);
            Console.WriteLine("Bob's raw key agreement (explicit):    " + Hex.ToHexString(keyAgreementBob));
            Console.WriteLine("Bob's hashed key agreement (explicit): " + Hex.ToHexString(keyAgreementSHA256Bob));
            Console.WriteLine("Bob's key agreement (.NET):            " + Hex.ToHexString(keyAgreementCngBob));
            Console.WriteLine();
        }
    }

    static byte[] GetKeyAgreementBC(X9ECParameters curve, ECPoint publicKey, byte[] privateKey)
    {
        var parameters = new ECDomainParameters(curve.Curve, curve.G, curve.N, curve.H);
        var privateKeyParameters = new ECPrivateKeyParameters(new BigInteger(1, privateKey), parameters);
        var publicKeyParameters = new ECPublicKeyParameters(publicKey, parameters);

        var agreement = AgreementUtilities.GetBasicAgreement("ECDH");
        agreement.Init(privateKeyParameters);

        return agreement.CalculateAgreement(publicKeyParameters).ToByteArray();
    }

    static byte[] GetKeyAgreementExplicit(X9ECParameters curve, ECPoint publicKey, byte[] privateKey)
    {
        var parameters = new ECDomainParameters(curve.Curve, curve.G, curve.N, curve.H);
        var privateKeyParameters = new ECPrivateKeyParameters(new BigInteger(1, privateKey), parameters);
        var publicKeyParameters = new ECPublicKeyParameters(publicKey, parameters);

        var p = curve.Curve.A.Multiply(privateKeyParameters.D).Add(publicKeyParameters.Q).Normalize();
        var hash = DigestUtilities.CreateDigest("SHA256");
        var kdf = new ECDHKDFParameters(p.Normalize().GetEncoded(), null, null);

        return KdfUtilities.GetKdf("ECDH").DeriveKey(hash, kdf).GetBytes(32);
    }
}