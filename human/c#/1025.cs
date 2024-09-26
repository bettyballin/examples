csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main()
    {
        string url = "http://your-service-url.com/endpoint"; // replace with your service url

        var client = new AdministrationServiceSoapClient(
            new BasicHttpBinding()
            {
                Security = new BasicHttpSecurity()
                           {
                               Mode = BasicHttpSecurityMode.TransportCredentialOnly,
                               Message = new BasicHttpMessageSecurity()
                                         {
                                             ClientCredentialType = BasicHttpMessageCredentialType.UserName,
                                         },
                               Transport = new HttpTransportSecurity()
                                           {
                                               ClientCredentialType = HttpClientCredentialType.Windows,
                                               ProxyCredentialType = HttpProxyCredentialType.Windows,
                                           }
                           },
            },
            new EndpointAddress(url));

        // use the client to make a request
        // client.SomeMethod();

        Console.WriteLine("Client created. Press Enter to exit.");
        Console.ReadLine();
    }
}