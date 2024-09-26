csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        using var ecdsa = ECDsa.Create();
        var result = new Result();
        result.Root = new X509Certificate2(ecdsa.ExportParameters(false));

        using var aKey = result.Root.GetECDsaPublicKey();
        result.A = CreateCert(aKey, "CN=Root CA", "A");

        var request = new CertificateRequest("CN=End Entity", aKey, HashAlgorithmName.SHA256);
        var cert = request.CreateSelfSigned(DateTime.UtcNow, DateTime.UtcNow.AddYears(1));
        Console.WriteLine(cert.ExportToPem());
    }

    static X509Certificate2 CreateCert(ECDsa key, string subjectName, string friendlyName)
    {
        var request = new CertificateRequest(subjectName, key, HashAlgorithmName.SHA256);
        var cert = request.CreateSelfSigned(DateTime.UtcNow, DateTime.UtcNow.AddYears(1));
        cert.FriendlyName = friendlyName;
        return cert;
    }

    class Result
    {
        public X509Certificate2 Root { get; set; }
        public X509Certificate2 A { get; set; }
    }
}