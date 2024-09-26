This is not C# code, it's a snippet of a Web.config or App.config file in XML format, used to configure WCF bindings. 

However, here is an example of a complete Web.config file with this binding:

xml
<?xml version="1.0"?>
<configuration>
  <system.serviceModel>
    <bindings>
      <basicHttpBinding>
        <binding name="BasicHttpEndpointBinding">
          <security mode="TransportCredentialOnly">
            <transport clientCredentialType="Basic" />
          </security>
        </binding>
      </basicHttpBinding>
    </bindings>
  </system.serviceModel>
</configuration>