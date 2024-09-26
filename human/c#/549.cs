csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main(string[] args)
    {
        string xml = @"
<wsHttpBinding>
    <binding name=""TransportSecurity"">
        <security mode=""Message"">
            <message clientCredentialType=""Windows"" algorithmSuite=""Default""/>
        </security>
    </binding>
</wsHttpBinding>";

        var binding = new WSHttpBinding();
        binding.Name = "TransportSecurity";
        binding.Security.Mode = SecurityMode.Message;
        binding.Security.Message.ClientCredentialType = MessageCredentialType.Windows;
        binding.Security.Message.AlgorithmSuite = SecurityAlgorithmSuite.Default;

        Console.WriteLine(binding.ToString());
    }
}