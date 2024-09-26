csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main()
    {
        using (ServiceHost serviceHost = new ServiceHost(typeof(eTutorWcfService)))
        {
            serviceHost.AddServiceEndpoint(typeof(eTutorWcfService), new NetTcpBinding(SecurityMode.None), "");
            serviceHost.Open();
            Console.WriteLine("Service is running...");
            Console.ReadLine();
            serviceHost.Close();
        }
    }
}