csharp
using System;
using System.ServiceModel;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            var binding = new BasicHttpBinding();
            var endpoint = new EndpointAddress("http://yourServer:8080/YourService/");
            var channelFactory = new ChannelFactory<IYourServiceContract>(binding, endpoint);
            var serviceClient = channelFactory.CreateChannel();
            // Use serviceClient to call methods on the service
        }
    }

    [ServiceContract]
    public interface IYourServiceContract
    {
        // Define your service methods here
    }
}