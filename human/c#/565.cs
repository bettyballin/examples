csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main()
    {
        WSHttpBinding binding = new WSHttpBinding();

        binding.Security.Mode = SecurityMode.Message;
        binding.Security.Message.EstablishSecurityContext = false;
        binding.Security.Message.NegotiateServiceCredential = false;

        Console.WriteLine("Binding settings:");
        Console.WriteLine($"Security Mode: {binding.Security.Mode}");
        Console.WriteLine($"Establish Security Context: {binding.Security.Message.EstablishSecurityContext}");
        Console.WriteLine($"Negotiate Service Credential: {binding.Security.Message.NegotiateServiceCredential}");
    }
}