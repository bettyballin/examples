csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Security;

class Program
{
    static void Main(string[] args)
    {
        var binding = new BasicHttpBinding();
        var endpointAddress = new EndpointAddress("http://localhost:6478/service/1.0");

        var client = new TestService.PortTypeClient(binding, endpointAddress);

        var username = "username";
        var password = "!password";

        client.ClientCredentials.UserName.UserName = username;
        client.ClientCredentials.UserName.Password = password;

        try
        {
            // Call a service method
            var result = client.SomeServiceMethod();
            Console.WriteLine(result);
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }
    }
}