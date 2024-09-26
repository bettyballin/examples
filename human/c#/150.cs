csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        var rsaAlgo1 = new RSACryptoServiceProvider();
        var rsaAlgo2 = new RSACryptoServiceProvider();

        var xml1 = rsaAlgo1.ToXmlString(true);
        var xml2 = rsaAlgo2.ToXmlString(true);

        if (xml1 != xml2)
        {
            Console.WriteLine("xml1 and xml2 are different");
        }
        else
        {
            Console.WriteLine("xml1 and xml2 are the same");
        }
    }
}