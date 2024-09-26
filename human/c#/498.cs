csharp
using System;
using System.ServiceModel;

namespace BasicHttpBindingConfig
{
    class Program
    {
        static void Main(string[] args)
        {
            BasicHttpBinding binding = new BasicHttpBinding("basicHttpEndpointBinding");

            binding.Security.Mode = BasicHttpSecurityMode.TransportWithMessageCredential;
            binding.Security.Transport.ClientCredentialType = HttpClientCredentialType.None;
            binding.Security.Message.ClientCredentialType = BasicHttpMessageCredentialType.Certificate;

            Console.WriteLine(binding.Name);
            Console.WriteLine(binding.Security.Mode);
            Console.WriteLine(binding.Security.Transport.ClientCredentialType);
            Console.WriteLine(binding.Security.Message.ClientCredentialType);
        }
    }
}