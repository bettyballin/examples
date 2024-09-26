csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main()
    {
        var binding = new WSHttpBinding();
        binding.Name = "wsHttpBindingMessageUname";
        binding.Security.Mode = SecurityMode.Message;
        binding.Security.Message.ClientCredentialType = MessageCredentialType.UserName;
        binding.Security.Message.NegotiateServiceCredential = true;
        binding.Security.Message.EstablishSecurityContext = false;

        Console.WriteLine(binding.ToString());
    }
}