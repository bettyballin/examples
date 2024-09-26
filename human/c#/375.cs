csharp
using System;
using System.ServiceModel;

namespace ServiceName
{
    [ServiceContract]
    public interface ContractName
    {
        // Define your service operations here
    }

    public class ServiceName : ContractName
    {
        // Implement your service operations here
    }

    class Program
    {
        static void Main(string[] args)
        {
            using (ServiceHost host = new ServiceHost(typeof(ServiceName)))
            {
                host.Open();

                Console.WriteLine("Service started. Press any key to exit...");
                Console.ReadKey();

                host.Close();
            }
        }
    }
}