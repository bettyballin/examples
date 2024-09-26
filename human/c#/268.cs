csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main(string[] args)
    {
        var binding = new WSHttpBinding();
        binding.Security.Mode = SecurityMode.Message;
        binding.Security.Message.ClientCredentialType = MessageCredentialType.UserName;

        var endpoint = new EndpointAddress("http://localhost:8080/service");
        var channelFactory = new ChannelFactory<IService>(binding, endpoint);
        var channel = channelFactory.CreateChannel();

        // Use the channel to call the service
        ((ICommunicationObject)channel).Close();
    }
}

interface IService
{
    void DoSomething();
}