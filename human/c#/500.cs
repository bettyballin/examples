csharp
using System;
using System.ServiceModel;

public class CustomBinding
{
    public static Binding CreateBinding()
    {
        var binding = new CustomBinding();

        var security = new SecurityBindingElement();
        security.SecurityHeaderLayout = SecurityHeaderLayout.Strict;
        security.DefaultAlgorithmSuite = SecurityAlgorithmSuite.Default;

        var transportSecurity = new TransportSecurityBindingElement();
        transportSecurity.EndpointSupportingTokenParameters.Signed.Add(new CertificateTokenParameters());
        security.Elements.Add(transportSecurity);

        var messageSecurity = new MessageSecurityBindingElement();
        messageSecurity.EndpointSupportingTokenParameters.Signed.Add(new CertificateTokenParameters());
        security.Elements.Add(messageSecurity);

        binding.Elements.Add(security);

        var httpsTransport = new HttpsTransportBindingElement();
        httpsTransport.AuthenticationScheme = AuthenticationSchemes.Anonymous;
        binding.Elements.Add(httpsTransport);

        return binding;
    }
}