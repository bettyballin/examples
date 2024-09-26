csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main()
    {
        var client = new MyServiceClient();

        client.ClientCredentials.UserName.UserName = "bob";
        client.ClientCredentials.UserName.Password = "1234";

        // Call a method on the service
        var result = client.MyMethod();

        Console.WriteLine(result);

        client.Close();
    }
}

[ServiceContract]
interface IMyService
{
    [OperationContract]
    string MyMethod();
}

public class MyServiceClient : ClientBase<IMyService>, IMyService
{
    public string MyMethod()
    {
        return Channel.MyMethod();
    }
}