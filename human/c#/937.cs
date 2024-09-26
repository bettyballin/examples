csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        byte[] privateKeyBytes = { /* your private key bytes here */ };
        X509Certificate2 x509Certificate =
            new X509Certificate2(privateKeyBytes, "", X509KeyStorageFlags.Exportable);
    }
}