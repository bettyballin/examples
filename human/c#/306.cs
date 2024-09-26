csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        X509Certificate2 cert = new X509Certificate2("key.pfx", "password", X509KeyStorageFlags.Exportable);
        string xml = cert.GetRSAPrivateKey().ToXmlString(true);
        Console.WriteLine(xml);
    }
}