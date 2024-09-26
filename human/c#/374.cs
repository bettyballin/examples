csharp
using System;
using System.IdentityModel.Selectors;
using System.IdentityModel.Tokens;
using System.Security.Principal;
using System.ServiceModel;

namespace Microsoft.ServiceModel.Samples.CalculatorService
{
    public class CustomUserNameValidator : UserNamePasswordValidator
    {
        public override void Validate(string userName, string password)
        {
            if (userName == null || password == null)
            {
                throw new ArgumentNullException();
            }

            if (userName != "test" || password != "test")
            {
                throw new SecurityTokenException("Unknown Username or Password");
            }
        }
    }

    [ServiceContract]
    public interface ICalculator
    {
        [OperationContract]
        int Add(int a, int b);
    }

    public class CalculatorService : ICalculator
    {
        public int Add(int a, int b)
        {
            return a + b;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            ServiceHost host = new ServiceHost(typeof(CalculatorService));
            host.Open();
            Console.WriteLine("Service started...");
            Console.ReadLine();
            host.Close();
        }
    }
}