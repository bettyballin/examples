csharp
using System;
using System.ServiceModel;

namespace CustomBindingExample
{
    class Program
    {
        static void Main(string[] args)
        {
            var binding = new CustomBinding(
                new TextMessageEncodingBindingElement(MessageVersion.Soap11, Encoding.UTF8),
                new SecurityBindingElement(
                    new UserNameOverTransportSecuritySettings(
                        new BasicSecurityProfile10SecuritySettings(
                            new WSSecurityPolicy11SecuritySettings(
                                new WSSecurity10WSTrustFebruary2005SecuritySettings(
                                    new WSSecureConversationFebruary2005SecuritySettings(
                                        new WSSecurity10SecuritySettings()
                                    )
                                )
                            )
                        )
                    )
                ),
                new HttpTransportBindingElement()
            );

            binding.Name = "UsernamePasswordOverHttp";
            binding.AllowInsecureTransport = true;

            var endpointAddress = new EndpointAddress("http://example.com/service");
            var channelFactory = new ChannelFactory<IService>(binding, endpointAddress);
            var channel = channelFactory.CreateChannel();

            // Use the channel to call the service
            // channel.SomeMethod();
        }
    }

    [ServiceContract]
    interface IService
    {
        // [OperationContract]
        // void SomeMethod();
    }
}