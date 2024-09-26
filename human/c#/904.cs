csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Security;

class Program
{
    static void Main()
    {
        var binding = new CustomBinding();

        var security = new SecurityBindingElement();
        security.AuthenticationMode = AuthenticationMode.SecureConversation;

        var localClientSettings = new LocalClientSecuritySettings();
        localClientSettings.MaxClockSkew = TimeSpan.FromMinutes(7);
        security.LocalClientSettings = localClientSettings;

        var localServiceSettings = new LocalServiceSecuritySettings();
        localServiceSettings.MaxClockSkew = TimeSpan.FromMinutes(7);
        security.LocalServiceSettings = localServiceSettings;

        var secureConversationBootstrap = new SecureConversationBootstrapBindingElement();
        secureConversationBootstrap.AuthenticationMode = AuthenticationMode.UserNameForCertificate;

        var localClientSettingsBootstrap = new LocalClientSecuritySettings();
        localClientSettingsBootstrap.MaxClockSkew = TimeSpan.FromMinutes(30);
        secureConversationBootstrap.LocalClientSettings = localClientSettingsBootstrap;

        var localServiceSettingsBootstrap = new LocalServiceSecuritySettings();
        localServiceSettingsBootstrap.MaxClockSkew = TimeSpan.FromMinutes(30);
        secureConversationBootstrap.LocalServiceSettings = localServiceSettingsBootstrap;

        security.Elements.Add(secureConversationBootstrap);

        binding.Elements.Add(security);
        binding.Elements.Add(new BinaryMessageEncodingBindingElement());
        binding.Elements.Add(new TcpTransportBindingElement());

        var endpointAddress = new EndpointAddress("net.tcp://localhost:8080/Service");
        var channelFactory = new ChannelFactory<IContract>(binding, endpointAddress);
        var channel = channelFactory.CreateChannel();
    }
}

interface IContract
{
    // Your contract methods here
}