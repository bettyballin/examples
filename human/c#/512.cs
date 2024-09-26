This is not C# code, it's a WCF configuration file in XML format. You cannot make this code "executable" as it is not a programming language code. However, I can provide you with an example of how to create a WCF service in C# that uses this configuration:

csharp
using System;
using System.ServiceModel;
using NLog.LogReceiverService;

namespace Your.Namespace.Path.To.Your.Service
{
    public class Service : ILogReceiverServer
    {
        public void Log(NLog.LogReceiverService.LogEvent logEvent)
        {
            // Implement logging logic here
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            using (ServiceHost host = new ServiceHost(typeof(Service)))
            {
                host.Open();
                Console.WriteLine("Service started. Press Enter to stop...");
                Console.ReadLine();
                host.Close();
            }
        }
    }
}


And the custom username validator:

csharp
using System.IdentityModel.Selectors;
using System.IdentityModel.Tokens;

namespace AssamblyOf.YourCustom.UsernameValidator
{
    public class UsernameValidator : UserNamePasswordValidator
    {
        public override void Validate(string userName, string password)
        {
            // Implement validation logic here
        }
    }
}


Note that you will need to replace the placeholders with your actual implementation and namespace. Also, make sure to install the necessary NuGet packages and configure the project correctly to use WCF.