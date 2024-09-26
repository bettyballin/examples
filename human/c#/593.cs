csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        X509Certificate2 cert = null;
        X509Store store = new X509Store(StoreName.My, StoreLocation.LocalMachine);
        store.Open(OpenFlags.ReadOnly);
        foreach (X509Certificate2 certificate in store.Certificates)
        {
            if (certificate.SubjectName.Name != null && certificate.SubjectName.Name.Contains("*.domain.xxx"))
            {
                cert = certificate;
            }
        }
        store.Close();
        Console.WriteLine(cert);
    }
}