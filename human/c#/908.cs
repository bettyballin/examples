csharp
using System;
using System.Configuration;
using System.ServiceModel;

namespace CustomBindingExample
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create a new instance of the service client
            ServiceReference1.IService client = new ServiceReference1.ServiceClient("CustomBinding_IService");

            // Call a method on the service
            // Replace "MyMethod" with the actual method you want to call
            client.MyMethod();

            // Close the client
            client.Close();
        }
    }
}


xml
<?xml version="1.0"?>
<configuration>
  <system.serviceModel>
    <bindings>
      <customBinding>
        <binding name="CustomBinding_IService">
          <security defaultAlgorithmSuite="Default" authenticationMode="SecureConversation"
            requireDerivedKeys="true" includeTimestamp="true" messageSecurityVersion="WSSecurity11WSTrustFebruary2005WSSecureConversationFebruary2005WSSecurityPolicy11BasicSecurityProfile10"
            requireSignatureConfirmation="false" canRenewSecurityContextToken="true">
            <secureConversationBootstrap defaultAlgorithmSuite="Default"
              authenticationMode="UserNameForCertificate" requireDerivedKeys="true"
              includeTimestamp="true" messageSecurityVersion="WSSecurity11WSTrustFebruary2005WSSecureConversationFebruary2005WSSecurityPolicy11BasicSecurityProfile10"
              requireSignatureConfirmation="false">
              <localClientSettings detectReplays="true" />
              <localServiceSettings detectReplays="true" />
            </secureConversationBootstrap>
            <localClientSettings detectReplays="true" />
            <localServiceSettings detectReplays="true" />
          </security>
          <binaryMessageEncoding />
          <tcpTransport />
        </binding>
      </customBinding>
    </bindings>
    <client>
      <endpoint address="net.tcp://10.157.13.69:800/" binding="customBinding"
        bindingConfiguration="CustomBinding_IService" contract="ServiceReference1.IService"
        name="CustomBinding_IService">
        <identity>
          <certificate encodedValue="blablabla" />
        </identity>
      </endpoint>
    </client>
  </system.serviceModel>
</configuration>