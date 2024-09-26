csharp
using System;
using System.ServiceModel;

[ServiceContract]
public interface ISomeService
{
    // Define your service contract here
    [OperationContract]
    void SomeMethod();
}

[ServiceBehavior(InstanceContextMode = InstanceContextMode.PerSession, ConcurrencyMode = ConcurrencyMode.Single)]
public class SomeService : ISomeService
{
    public void SomeMethod()
    {
        Console.WriteLine("SomeMethod called");
    }
}

public class Program
{
    public static void Main()
    {
        using (ServiceHost host = new ServiceHost(typeof(SomeService)))
        {
            host.Open();
            Console.WriteLine("Service started. Press any key to stop...");
            Console.ReadKey();
            host.Close();
        }
    }
}