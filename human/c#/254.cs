csharp
using System;
using System.ServiceModel;

namespace WCFConfig
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create a new ServiceHost
            var host = new ServiceHost(typeof(MyService));

            // Configure the binding
            var binding = new WSHttpBinding("securitySession");
            binding.Security.Mode = SecurityMode.Message;
            binding.Security.Message.ClientCredentialType = MessageCredentialType.UserName;
            binding.Security.Message.EstablishSecurityContext = true;
            binding.Security.Message.NegotiateServiceCredential = false;

            // Add the endpoint
            host.AddServiceEndpoint(typeof(IMyService), binding, "http://localhost:8080/MyService");

            // Open the host
            host.Open();
            Console.WriteLine("Service is running...");
            Console.ReadLine();
            host.Close();
        }
    }

    [ServiceContract]
    public interface IMyService
    {
        [OperationContract]
        void DoSomething();
    }

    public class MyService : IMyService
    {
        public void DoSomething()
        {
            Console.WriteLine("Doing something...");
        }
    }
}