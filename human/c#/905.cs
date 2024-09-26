csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Security;

class Program
{
    static void Main(string[] args)
    {
        using (ServiceHost sh = new ServiceHost(typeof(MyService)))
        {
            sh.Credentials.UserNameAuthentication.UserNamePasswordValidationMode = UserNamePasswordValidationMode.Custom;
            sh.Credentials.UserNameAuthentication.CustomUserNamePasswordValidator = new MyValidator();
            sh.Open();
            Console.WriteLine("Service is ready....");

            Console.ReadLine();
            sh.Close();
        }
    }
}

[ServiceContract]
interface IService
{
    [OperationContract]
    string GetData();
}

public class MyService : IService
{
    public string GetData()
    {
        return DateTime.Now.ToString();
    }
}

public class MyValidator : UserNamePasswordValidator
{
    public override void Validate(string userName, string password)
    {
        if (userName != "jack" || password != "123456")
        {
            throw new FaultException("My Error");
        }
    }
}