csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main(string[] args)
    {
        // Create a binding with HTTPS and Basic Authentication
        var binding = new BasicHttpBinding(BasicHttpSecurityMode.Transport);
        binding.Security.Transport.ClientCredentialType = HttpClientCredentialType.Basic;

        // Create a service host
        var host = new ServiceHost(typeof(MyService));

        // Add the binding to the service host
        host.AddServiceEndpoint(typeof(IMyService), binding, "https://localhost:8080/MyService");

        // Open the service host
        host.Open();

        Console.WriteLine("Service started. Press Enter to stop...");
        Console.ReadLine();

        // Close the service host
        host.Close();
    }
}

[ServiceContract]
public interface IMyService
{
    [OperationContract]
    string GetData();
}

public class MyService : IMyService
{
    public string GetData()
    {
        return "Hello, World!";
    }
}