csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        X509Certificate2 publicCert = new X509Certificate2(@"C:\mycertificate.cer");

        //Fetch private key from the local machine store
        X509Certificate2 privateCert = null;
        X509Store store = new X509Store(StoreLocation.LocalMachine);
        store.Open(OpenFlags.ReadOnly);
        foreach( X509Certificate2 cert in store.Certificates)
        {
            if (cert.GetCertHashString() == publicCert.GetCertHashString())
                privateCert = cert;
        }

        Console.WriteLine(privateCert != null ? "Private key found" : "Private key not found");
    }
}