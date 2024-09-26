csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Discovery;
using System.Xml.Linq;

class Program
{
    private static ServiceHost _host;

    static void Main(string[] args)
    {
        var address = CommonMethods.GetIpLocalAddress();

        _host = new ServiceHost(typeof(AgentService), new Uri(string.Format("net.tcp://{0}/AgentService", address)));

        var endpoint = _host.AddServiceEndpoint(typeof(IAgent), new NetTcpBinding(), String.Empty);

        var metadataProvider = new CiscoMetaDataProvider();

        var discoveryBehavior = new EndpointDiscoveryBehavior();
        discoveryBehavior.Scopes.Add(new Uri("net.tcp://blablabla.com/CallTesting/AgentService/1/Cisco"));
        discoveryBehavior.Extensions.Add(new XElement("phoneNumber", metadataProvider.GetPhoneNumber()));

        endpoint.Behaviors.Add(discoveryBehavior);

        var discoveryEndpoint = new UdpDiscoveryEndpoint();

        _host.AddServiceEndpoint(discoveryEndpoint);

        ServiceDiscoveryBehavior serviceDiscoveryBehavior = new ServiceDiscoveryBehavior();

        serviceDiscoveryBehavior.AnnouncementEndpoints.Add(new UdpAnnouncementEndpoint());

        _host.Description.Behaviors.Add(serviceDiscoveryBehavior);

        _host.Open();

        Console.WriteLine("Service is running. Press any key to exit.");
        Console.ReadKey();

        _host.Close();
    }
}

// Assuming you have these classes defined elsewhere in your codebase
public class CommonMethods
{
    public static string GetIpLocalAddress()
    {
        // Your implementation here
        throw new NotImplementedException();
    }
}

public class AgentService : IAgent
{
    // Your implementation here
}

public interface IAgent
{
    // Your implementation here
}

public class CiscoMetaDataProvider
{
    public string GetPhoneNumber()
    {
        // Your implementation here
        throw new NotImplementedException();
    }
}