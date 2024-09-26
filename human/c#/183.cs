csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main(string[] args)
    {
        var binding = new BasicHttpBinding(BasicHttpSecurityMode.TransportWithMessageCredential);
        binding.Security.Message.ClientCredentialType = BasicHttpMessageCredentialType.UserName;

        var endpoint = new EndpointAddress(new Uri("https://..."));

        var channelFactory = new ChannelFactory<IContract>(binding, endpoint);
        channelFactory.Credentials.UserName.UserName = "username";
        channelFactory.Credentials.UserName.Password = "password";

        var proxy = channelFactory.CreateChannel();

        // Call service operations using the proxy
        // proxy.ServiceOperation();
    }
}

[ServiceContract]
interface IContract
{
    // Define service operations
    // [OperationContract]
    // void ServiceOperation();
}