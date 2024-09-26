csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        string MyDir = AppDomain.CurrentDomain.BaseDirectory;
        X509Certificate2 cert = new X509Certificate2(MyDir + "RpaKey.pfx", "");
        Console.WriteLine("Loading certificate... private key available ? {0}", cert.HasPrivateKey);
    }
}