csharp
using Org.BouncyCastle.Math;
using Org.BouncyCastle.Math.EC;

public class Program
{
    public static byte[] GetKeyAgreementExplicit(X9ECParameters ecParams, ECPoint publicKey, byte[] privateKey)
    {
        ECDomainParameters eCDomainParameters = new ECDomainParameters(ecParams.Curve, ecParams.G, ecParams.N);
        ECCurve curve = eCDomainParameters.Curve;
        
        ECPoint pubKey = curve.CreatePoint(new BigInteger(1, publicKey.X), new BigInteger(1, publicKey.Y));
        BigInteger privKey = new BigInteger(1, privateKey);
        
        ECPoint keyAgreementECPoint = pubKey.Multiply(privKey).Normalize();
        byte[] keyAgreement = keyAgreementECPoint.XCoord.ToBigInteger().ToByteArrayUnsigned();
        return keyAgreement;
    }

    public static void Main(string[] args)
    {
        // Example usage
        X9ECParameters ecParams = NistNamedCurves.GetByName("P-256");
        ECPoint publicKey = new ECPoint(new BigInteger("1234567890abcdef", 16), new BigInteger("fedcba0987654321", 16));
        byte[] privateKey = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

        byte[] keyAgreement = GetKeyAgreementExplicit(ecParams, publicKey, privateKey);

        System.Console.WriteLine(BitConverter.ToString(keyAgreement));
    }
}