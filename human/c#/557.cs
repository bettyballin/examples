csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Description;

namespace WCFClient
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create a client endpoint address
            EndpointAddress address = new EndpointAddress("http://localhost:8000/WCFService");

            // Create a client binding
            WSHttpBinding binding = new WSHttpBinding();

            // Create a client endpoint behavior
            EndpointBehavior behavior = new EndpointBehavior();

            // Set the client credentials
            behavior.ClientCredentials.ServiceCertificate.Authentication.CertificateValidationMode = X509CertificateValidationMode.PeerOrChainTrust;
            behavior.ClientCredentials.ServiceCertificate.Authentication.RevocationMode = X509RevocationMode.NoCheck;

            // Create a client channel factory
            ChannelFactory<IService> factory = new ChannelFactory<IService>(binding, address);

            // Add the endpoint behavior to the channel factory
            factory.Endpoint.Behaviors.Add(behavior);

            // Create a client channel
            IService channel = factory.CreateChannel();

            // Call the service operation
            channel.MyOperation();

            // Close the client channel
            ((ICommunicationObject)channel).Close();
        }
    }
}