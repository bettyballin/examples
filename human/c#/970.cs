csharp
using System;
using Org.BouncyCastle.Asn1.Sec;
using Org.BouncyCastle.Asn1.X9;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Agreement;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.Math;
using Org.BouncyCastle.Math.EC;

public class Program
{
    public static byte[] GetKeyAgreementBC(X9ECParameters ecParams, ECPoint publicKey, byte[] privateKey)
    {
        ECDomainParameters eCDomainParameters = new ECDomainParameters(ecParams.Curve, ecParams.G, ecParams.N);
        Org.BouncyCastle.Math.EC.ECCurve curve = eCDomainParameters.Curve;

        Org.BouncyCastle.Math.EC.ECPoint pubKey = curve.CreatePoint(new BigInteger(1, publicKey.X), new BigInteger(1, publicKey.Y));
        BigInteger privKey = new BigInteger(1, privateKey);

        ECPublicKeyParameters ecPubKeyParams = new ECPublicKeyParameters("ECDH", pubKey, SecObjectIdentifiers.SecP256r1);
        ECPrivateKeyParameters ecPrivKeyParams = new ECPrivateKeyParameters(privKey, eCDomainParameters);

        IBasicAgreement basicAgreement = AgreementUtilities.GetBasicAgreement("ECDH");
        basicAgreement.Init(ecPrivKeyParams);
        byte[] keyAgreement = basicAgreement.CalculateAgreement(ecPubKeyParams).ToByteArrayUnsigned();
        return keyAgreement;
    }

    public static void Main(string[] args)
    {
        // Example usage:
        X9ECParameters ecParams = SecNamedCurves.GetByName("secp256r1");
        ECPoint publicKey = new ECPoint(BigInteger.ValueOf(1), BigInteger.ValueOf(2));
        byte[] privateKey = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 };
        byte[] keyAgreement = GetKeyAgreementBC(ecParams, publicKey, privateKey);
        Console.WriteLine(BitConverter.ToString(keyAgreement));
    }
}