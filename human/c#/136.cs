csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        X509Certificate2 cert = new X509Certificate2(@"C:\Path\my.pfx", "password");
    }
}