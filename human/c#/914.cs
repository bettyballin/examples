csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Description;

class Program
{
    static void Main(string[] args)
    {
        Uri uri = new Uri("http://localhost:8080");
        using (WebServiceHost sh = new WebServiceHost(typeof(MyService), uri))
        {
            Binding binding = new BasicHttpBinding();
            sh.AddServiceEndpoint(typeof(IService), binding, "");
            ServiceMetadataBehavior smb;
            smb = sh.Description.Behaviors.Find<ServiceMetadataBehavior>();
            if (smb == null)
            {
                smb = new ServiceMetadataBehavior()
                {
                    HttpGetEnabled = true
                };
                sh.Description.Behaviors.Add(smb);
            }
            sh.Credentials.UserNameAuthentication.UserNamePasswordValidationMode = System.ServiceModel.Security.UserNamePasswordValidationMode.Custom;
            sh.Credentials.UserNameAuthentication.CustomUserNamePasswordValidator = new CustUserNamePasswordVal();
            Binding mexbinding = MetadataExchangeBindings.CreateMexHttpBinding();
            sh.AddServiceEndpoint(typeof(IMetadataExchange), mexbinding, "mex");
            sh.Opened += delegate
            {
                Console.WriteLine("Service is ready");
            };
            sh.Closed += delegate
            {
                Console.WriteLine("Service is closed");
            };
            sh.Open();
            Console.ReadLine();
            //pause
            sh.Close();
            Console.ReadLine();
        }
    }
}

[ServiceContract]
public interface IService
{
    [OperationContract]
    void DoWork();
}

public class MyService : IService
{
    public void DoWork()
    {
        Console.WriteLine("Service is working");
    }
}

public class CustUserNamePasswordVal : UserNamePasswordValidator
{
    public override void Validate(string userName, string password)
    {
        if (userName != "test" || password != "test")
        {
            throw new FaultException("Invalid credentials");
        }
    }
}