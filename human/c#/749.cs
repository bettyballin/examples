csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        string certRawData = "30820494020101310D300B0609608648016503040201301406092A864886F70D010701A0070405656C6C6F";
        string issuerNameRawData = "318201C2308201BE020101308198";
        string signature = "0209009B5DE6C15126A58B300B0609608648016503040201300D06092A864886F70D01010101050004800100";

        byte[] certBytes = Convert.FromHexString(certRawData + issuerNameRawData + signature);

        X509Certificate2 cert = new X509Certificate2(certBytes);

        Console.WriteLine(cert.Subject);
        Console.WriteLine(cert.Issuer);
        Console.WriteLine(cert.GetExpirationDateString());
        Console.WriteLine(cert.GetEffectiveDateString());
    }
}