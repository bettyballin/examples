csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Security;

public class ArtikelPortTypeClientFactory
{
    private readonly IntegrationConfiguration _integrationConfiguration;

    public ArtikelPortTypeClientFactory(IntegrationConfiguration integrationConfiguration)
    {
        _integrationConfiguration = integrationConfiguration;
    }

    public ArtikelPortTypeClient CreateArtikelClient()
    {
        var binding = new BasicHttpsBinding(BasicHttpsSecurityMode.Transport);
        binding.Security.Transport.ClientCredentialType = HttpClientCredentialType.Basic;

        var client = new ArtikelPortTypeClient(binding, new EndpointAddress(_integrationConfiguration.EndpointAddress));
        client.ClientCredentials.UserName.UserName = _integrationConfiguration.UserName;
        client.ClientCredentials.UserName.Password = _integrationConfiguration.Password;
        return client;
    }
}

public class IntegrationConfiguration
{
    public string EndpointAddress { get; set; }
    public string UserName { get; set; }
    public string Password { get; set; }
}

public class ArtikelPortTypeClient : ClientBase<IArtikelPortType>
{
    public ArtikelPortTypeClient(Binding binding, EndpointAddress address) 
        : base(binding, address)
    {
    }
}

[ServiceContract]
public interface IArtikelPortType
{
    // Add your service operations here
}

class Program
{
    static void Main(string[] args)
    {
        var integrationConfiguration = new IntegrationConfiguration
        {
            EndpointAddress = "https://example.com/artikel",
            UserName = "username",
            Password = "password"
        };

        var factory = new ArtikelPortTypeClientFactory(integrationConfiguration);
        var client = factory.CreateArtikelClient();

        // Use the client
        Console.WriteLine("Client created");
    }
}