csharp
using System;
using System.Configuration;

public class WebHttpBindingConfiguration
{
    public static void Main()
    {
        string config = @"
        <bindings>
          <webHttpBinding>
            <binding name=""httpsWebBinding"">
              <security mode=""Transport"">
                <!--<transport clientCredentialType=""None"" proxyCredentialType=""None"" />-->
                <transport clientCredentialType=""Windows"" proxyCredentialType=""Windows"" />
              </security>
            </binding>
            <binding name=""httpWebBinding"">
              <security mode=""None"">
                <!--<transport clientCredentialType=""None"" proxyCredentialType=""None"" />-->
                <transport clientCredentialType=""Windows"" proxyCredentialType=""Windows"" />
              </security>
            </binding>
          </webHttpBinding>
        </bindings>";

        Configuration configuration = ConfigurationManager.OpenExeConfiguration(ConfigurationUserLevel.None);
        configuration.Sections.Add("system.serviceModel/bindings", new ConfigurationSection { SectionInformation = new SectionInformation { Name = "bindings" } });
        configuration.Sections["system.serviceModel/bindings"].SectionInformation.SetRawXml(config);
    }
}