csharp
using System;
using System.Security.Cryptography;
using System.Numerics;
using System.Linq;

class Program
{
    static void Main()
    {
        RSACryptoServiceProvider rsa = new RSACryptoServiceProvider(384);
        var p = rsa.ExportParameters(true);
        var primeq = new BigInteger(p.Q.Reverse().Concat(new Byte[1]).ToArray());
        Console.WriteLine(primeq);
    }
}