using System;
using System.Configuration;

namespace MyService
{
    public class ServiceCredentials
    {
        public ClientCertificate ClientCertificate { get; set; }
    }

    public class ClientCertificate
    {
        public Authentication Authentication { get; set; }
    }

    public class Authentication
    {
        public string CertificateValidationMode { get; set; }
        public string RevocationMode { get; set; }
    }

    class Program
    {
        static void Main(string[] args)
        {
            ServiceCredentials serviceCredentials = new ServiceCredentials
            {
                ClientCertificate = new ClientCertificate
                {
                    Authentication = new Authentication
                    {
                        CertificateValidationMode = "ChainTrust",
                        RevocationMode = "NoCheck"
                    }
                }
            };
        }
    }
}