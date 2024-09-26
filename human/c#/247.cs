csharp
using System;
using Org.BouncyCastle.Crypto.Parameters;

class Program
{
    static void Main()
    {
        var rsaKeyParameters = new RsaKeyParameters(false, new Org.BouncyCastle.Math.BigInteger("12345678901234567890"), new Org.BouncyCastle.Math.BigInteger("12345678901234567890"));
        Console.WriteLine(rsaKeyParameters.Modulus);
        Console.WriteLine(rsaKeyParameters.Exponent);
    }
}