csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main()
    {
        var client = new ServiceClient();
        var endpoint = client.Endpoint;
        endpoint.Address = new EndpointAddress("blah");
        endpoint.Binding = new BasicHttpBinding("blah");
        endpoint.Contract = typeof(blah);
        endpoint.Name = "blah";
        endpoint.Behaviors.Add(new MyEndpointBehaviours());
    }
}

public class ServiceClient
{
    public Endpoint Endpoint { get; set; }
}

public class MyEndpointBehaviours : IEndpointBehavior
{
    public void AddBindingParameters(ServiceEndpoint endpoint, BindingParameterCollection bindingParameters)
    {
    }

    public void ApplyClientBehavior(ServiceEndpoint endpoint, ClientRuntime clientRuntime)
    {
    }

    public void ApplyDispatchBehavior(ServiceEndpoint endpoint, EndpointDispatcher endpointDispatcher)
    {
    }

    public void Validate(ServiceEndpoint endpoint)
    {
    }
}