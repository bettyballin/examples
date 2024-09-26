csharp
using System;
using System.Security.Cryptography;
using System.Numerics;
using System.Linq;

class Program
{
    static void Main()
    {
        using (var rsa = new RSACryptoServiceProvider()) {
            var a = rsa.ExportParameters(true);
            BigInteger p = new BigInteger(a.P.Reverse().Concat(new byte[1]).ToArray());
            BigInteger q = new BigInteger(a.Q.Reverse().Concat(new byte[1]).ToArray());
            BigInteger n = new BigInteger(a.Modulus.Reverse().Concat(new byte[1]).ToArray());
            Console.WriteLine(p * q == n);
        }
    }
}