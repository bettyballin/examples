csharp
using System;
using System.ServiceModel;
using System.ServiceModel.Description;

namespace Server1
{
    public class MyService : IService
    {
        // Implement IService contract
    }

    public class MyValidator : UserNamePasswordValidator
    {
        public override void Validate(string userName, string password)
        {
            // Implement custom validation logic
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            using (ServiceHost host = new ServiceHost(typeof(MyService)))
            {
                host.Open();
                Console.WriteLine("Service started. Press any key to stop...");
                Console.ReadKey();
                host.Close();
            }
        }
    }
}