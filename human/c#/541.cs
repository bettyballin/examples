csharp
using System;
using System.Security.Cryptography;
using System.Xml;

public class RSAToXML
{
    public static void Main(string[] args)
    {
        using (var rsa = RSA.Create(1024))
        {
            var parameters = rsa.ExportParameters(false);
            Console.WriteLine("<RSAKeyValue>");
            Console.Write("\t<Modulus>");
            Console.Write(Convert.ToBase64String(parameters.Modulus));
            Console.WriteLine("</Modulus>");
            Console.Write("\t<Exponent>");
            Console.Write(Convert.ToBase64String(parameters.Exponent));
            Console.WriteLine("</Exponent>");
            Console.WriteLine("</RSAKeyValue>");
        }
    }
}