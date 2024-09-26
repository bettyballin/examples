csharp
using Org.BouncyCastle.Crypto.Parameters;

class Program
{
    static void Main()
    {
        var rsaPrivateCrtKeyParameters = new RsaPrivateCrtKeyParameters(
            new BigInteger("1234567890123456789012345678901234567890"), // e
            new BigInteger("1234567890123456789012345678901234567890"), // d
            new BigInteger("1234567890123456789012345678901234567890"), // n
            new BigInteger("1234567890123456789012345678901234567890"), // p
            new BigInteger("1234567890123456789012345678901234567890"), // q
            new BigInteger("1234567890123456789012345678901234567890"), // dP
            new BigInteger("1234567890123456789012345678901234567890"), // dQ
            new BigInteger("1234567890123456789012345678901234567890")  // qInv
        );
    }
}