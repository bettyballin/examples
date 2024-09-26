csharp
using System;
using System.Security.Cryptography.X509Certificates;
using System.ServiceModel;

class Program
{
    static void Main()
    {
        // Create a new instance of the service
        var service = new ServiceReference1.MyServiceClient();

        // Set the client certificate
        service.ClientCredentials.ClientCertificate.Certificate = new X509Certificate2("path_to_your_certificate.pfx", "password");

        // Call a method on the service
        service.MyMethod();

        // Close the service
        service.Close();
    }
}