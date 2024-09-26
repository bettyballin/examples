csharp
using System;
using System.Security.Cryptography.X509Certificates;
using System.Web;

public class CertificateLoader
{
    public X509Certificate2 LoadCertificate(HttpRequest request)
    {
        return new X509Certificate2(request.ClientCertificate.Certificate);
    }
}

class Program
{
    static void Main()
    {
        var httpRequest = new HttpRequest("", "https://example.com", "");
        var certificateLoader = new CertificateLoader();
        var x509Cert2 = certificateLoader.LoadCertificate(httpRequest);
    }
}