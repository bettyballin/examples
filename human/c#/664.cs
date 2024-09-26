csharp
using System;
using Org.BouncyCastle.Crypto.Parameters;

class Program
{
    static void Main()
    {
        var modulus = new Org.BouncyCastle.Math.BigInteger("323");
        var exponent = new Org.BouncyCastle.Math.BigInteger("17");

        RsaKeyParameters keyParameters = new RsaKeyParameters(false, modulus, exponent);
    }
}