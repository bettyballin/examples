csharp
using System;
using System.ServiceModel;

[ServiceContract(ConfigurationName = "ServiceReference1.SimpleServiceSoap", ProtectionLevel = ProtectionLevel.Sign)]
public interface ISimpleServiceSoap
{
    // Add your service methods here
}

class Program
{
    static void Main()
    {
        ServiceHost host = new ServiceHost(typeof(SimpleServiceSoap));
        host.Open();
        Console.WriteLine("Service started. Press any key to exit.");
        Console.ReadKey();
        host.Close();
    }
}

public class SimpleServiceSoap : ISimpleServiceSoap
{
    // Implement your service methods here
}