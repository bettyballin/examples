csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main(string[] args)
    {
        var binding = new WSHttpBinding("Binding1")
        {
            Security =
            {
                Mode = SecurityMode.Message,
                Message =
                {
                    ClientCredentialType = MessageCredentialType.UserName
                }
            }
        };

        var endpointAddress = new EndpointAddress("http://localhost:8080/service");

        var channelFactory = new ChannelFactory<IServiceContract>(binding, endpointAddress);
        var client = channelFactory.CreateChannel();

        // Use the client to call service operations
        ((IClientChannel)client).Close();
        channelFactory.Close();
    }
}

[ServiceContract]
interface IServiceContract
{
    // Define service operations
}