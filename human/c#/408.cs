csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Security;

public class CustomBindingExample
{
    public static void Main(string[] args)
    {
        // Create a custom binding
        var binding = new CustomBinding();

        // Add a text message encoding element
        var textMessageEncoding = new TextMessageEncodingBindingElement();
        textMessageEncoding.MessageVersion = MessageVersion.Default;
        binding.Elements.Add(textMessageEncoding);

        // Add a security element
        var security = new SecurityBindingElement();
        security.AuthenticationMode = AuthenticationMode.UserNameOverTransport;
        var secureConversationBootstrap = new SecureConversationBootstrapBindingElement();
        security.Elements.Add(secureConversationBootstrap);
        binding.Elements.Add(security);

        // Add an HTTPS transport element
        var httpsTransport = new HttpsTransportBindingElement();
        httpsTransport.RequireClientCertificate = true;
        binding.Elements.Add(httpsTransport);

        // Create a service host
        var serviceHost = new ServiceHost(typeof(MyService));
        serviceHost.AddServiceEndpoint(typeof(IMyService), binding, "https://localhost:8080/MyService");

        // Open the service host
        serviceHost.Open();

        Console.WriteLine("Service started. Press Enter to stop.");
        Console.ReadLine();

        // Close the service host
        serviceHost.Close();
    }
}

[ServiceContract]
public interface IMyService
{
    [OperationContract]
    string HelloWorld();
}

public class MyService : IMyService
{
    public string HelloWorld()
    {
        return "Hello, World!";
    }
}