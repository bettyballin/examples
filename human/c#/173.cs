csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Description;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        // Create a new service host
        ServiceHost host = new ServiceHost(typeof(MyService));

        // Create a new binding
        WSHttpBinding binding = new WSHttpBinding();
        binding.Name = "SecureBinding";
        binding.MessageEncoding = WSMessageEncoding.Mtom;
        binding.MaxReceivedMessageSize = 4194304;
        binding.ReaderQuotas.MaxStringContentLength = 4194304;
        binding.ReaderQuotas.MaxArrayLength = 4194304;

        // Create a new security binding
        binding.Security.Mode = SecurityMode.Message;
        binding.Security.Message.ClientCredentialType = MessageCredentialType.UserName;
        binding.Security.Message.NegotiateServiceCredential = true;
        binding.Security.Message.EstablishSecurityContext = true;

        // Add the binding to the service host
        host.AddServiceEndpoint(typeof(IMyService), binding, "https://localhost:8080/MyService");

        // Create a new service behavior
        ServiceBehaviorAttribute behavior = new ServiceBehaviorAttribute();
        behavior.Name = "DefaultServiceBehavior";

        // Add the service metadata behavior
        ServiceMetadataBehavior metadataBehavior = new ServiceMetadataBehavior();
        metadataBehavior.HttpsGetEnabled = true;
        host.Description.Behaviors.Add(metadataBehavior);

        // Add the service debug behavior
        ServiceDebugBehavior debugBehavior = new ServiceDebugBehavior();
        debugBehavior.IncludeExceptionDetailInFaults = true;
        host.Description.Behaviors.Add(debugBehavior);

        // Add the service authorization behavior
        ServiceAuthorizationBehavior authorizationBehavior = new ServiceAuthorizationBehavior();
        authorizationBehavior.PrincipalPermissionMode = PrincipalPermissionMode.UseAspNetRoles;
        authorizationBehavior.RoleProviderName = "SqlRoleProvider";
        host.Description.Behaviors.Add(authorizationBehavior);

        // Add the service credentials behavior
        ServiceCredentials serviceCredentials = new ServiceCredentials();
        serviceCredentials.UserNameAuthentication.UserNamePasswordValidationMode = UserNamePasswordValidationMode.MembershipProvider;
        serviceCredentials.UserNameAuthentication.MembershipProviderName = "SqlMembershipProvider";

        // Load the service certificate
        X509Certificate2 certificate = new X509Certificate2("SecureChannelCertificate", "password");
        serviceCredentials.ServiceCertificate.Certificate = certificate;

        host.Description.Behaviors.Add(serviceCredentials);

        // Open the service host
        host.Open();

        Console.WriteLine("Service started. Press any key to stop...");
        Console.ReadKey();

        // Close the service host
        host.Close();
    }
}