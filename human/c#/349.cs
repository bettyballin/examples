csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main(string[] args)
    {
        var binding = new BasicHttpBinding(BasicHttpSecurityMode.TransportWithMessageCredential);
        binding.Security.Transport.ClientCredentialType = HttpClientCredentialType.None;
        binding.Security.Message.ClientCredentialType = BasicHttpMessageCredentialType.UserName;
    }
}