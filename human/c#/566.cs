csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Description;

class Program
{
    static void Main(string[] args)
    {
        var serviceClient = new YourServiceClient();
        serviceClient.Endpoint.EndpointBehaviors.Add(new ClientViaBehavior(new Uri("http://url/WCFService/ServiceName.svc")));
        serviceClient.Open();
        // Your service calls here
        serviceClient.Close();
    }
}

public class YourServiceClient : ClientBase<IYourService>
{
    public YourServiceClient() : base(new BasicHttpBinding(), new EndpointAddress("http://url/WCFService/ServiceName.svc")) { }

    // Your service methods here
}

[ServiceContract]
public interface IYourService
{
    // Your service contracts here
}