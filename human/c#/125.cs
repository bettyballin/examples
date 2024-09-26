csharp
using System;
using System.ServiceModel;

namespace MyServiceContractLib
{
    [ServiceContract]
    public interface IMyService
    {
        // Your service methods here
    }
}

namespace MyServiceHost
{
    class Program
    {
        static void Main(string[] args)
        {
            var host = new ServiceHost(typeof(MyService));
            var endpoint = host.AddServiceEndpoint(typeof(MyServiceContractLib.IMyService), new BasicHttpBinding(), "http://localhost:8972");

            var clientIdentification = new ClientIdentification("ASP_Client");
            endpoint.Behaviors.Add(new HeaderBehavior(clientIdentification));

            host.Open();
            Console.WriteLine("Service started. Press any key to exit...");
            Console.ReadKey();
            host.Close();
        }
    }

    public class ClientIdentification
    {
        public string Value { get; set; }

        public ClientIdentification(string value)
        {
            Value = value;
        }
    }

    public class HeaderBehavior : IEndpointBehavior
    {
        private ClientIdentification _clientIdentification;

        public HeaderBehavior(ClientIdentification clientIdentification)
        {
            _clientIdentification = clientIdentification;
        }

        public void AddBindingParameters(ServiceEndpoint endpoint, BindingParameterCollection bindingParameters)
        {
        }

        public void ApplyClientBehavior(ServiceEndpoint endpoint, ClientRuntime clientRuntime)
        {
        }

        public void ApplyDispatchBehavior(ServiceEndpoint endpoint, EndpointDispatcher endpointDispatcher)
        {
            endpointDispatcher.DispatchRuntime.MessageInspectors.Add(new HeaderInspector(_clientIdentification));
        }

        public void Validate(ServiceEndpoint endpoint)
        {
        }
    }

    public class HeaderInspector : IDispatchMessageInspector
    {
        private ClientIdentification _clientIdentification;

        public HeaderInspector(ClientIdentification clientIdentification)
        {
            _clientIdentification = clientIdentification;
        }

        public object AfterReceiveRequest(ref Message request, IClientChannel channel, InstanceContext instanceContext)
        {
            return null;
        }

        public void BeforeSendReply(ref Message reply, object correlationState)
        {
            reply.Headers.Add(MessageHeader.CreateHeader("ClientIdentification", "", _clientIdentification.Value));
        }
    }
}