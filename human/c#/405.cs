csharp
using System;
using System.IdentityModel.Selectors;
using System.IO;
using System.Net;
using System.Security.Cryptography;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.ServiceModel.Web;
using System.Text;

public class CustomAuthorizationManager : ServiceAuthorizationManager 
{
    private const string UserName = "username";
    private const string Password = "password";

    protected override bool CheckAccessCore(OperationContext operationContext)
    {
        string authHeader = WebOperationContext.Current.IncomingRequest.Headers["Authorization"];

        if ((authHeader != null) && (authHeader != string.Empty))
        {
            string[] svcCredentials = System.Text.ASCIIEncoding.ASCII
                                        .GetString(Convert.FromBase64String(authHeader.Substring(6)))
                                        .Split(':');

            var user = new { Name = svcCredentials[0], Password = svcCredentials[1] };

            if ((user.Name.Equals(UserName) && user.Password.Equals(Password)))
                return true;
            else
                return false;
        }
        else
        {
            WebOperationContext.Current.OutgoingResponse.Headers.Add("WWW-Authenticate: Basic realm=\"PsmProvider\"");
            throw new WebFaultException(HttpStatusCode.Unauthorized);
        }
    }

}

class Program
{
    static void Main(string[] args)
    {
        Uri baseAddress = new Uri("http://localhost:8080/");

        var host = new ServiceHost(typeof(CustomService), baseAddress);

        var binding = new WebHttpBinding { Security = { Mode = WebHttpSecurityMode.TransportCredentialOnly } };
        var endpoint = host.AddServiceEndpoint(typeof(ICustomService), binding, "");

        var authBehavior = new ServiceAuthorizationBehavior
        {
            ServiceAuthorizationManager = new CustomAuthorizationManager()
        };
        host.Description.Behaviors.Add(authBehavior);

        host.Open();

        Console.WriteLine("Service is running");
        Console.ReadLine();

        host.Close();
    }
}

public class CustomService : ICustomService
{
    [OperationContract]
    public string GetData()
    {
        return "Hello, world!";
    }
}

[ServiceContract]
public interface ICustomService
{
    [OperationContract]
    string GetData();
}