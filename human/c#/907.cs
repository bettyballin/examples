csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main(string[] args)
    {
        ServiceReference1.ServiceClient client = new ServiceReference1.ServiceClient();
        client.ClientCredentials.UserName.UserName = "jack";
        client.ClientCredentials.UserName.Password = "123456";
        try
        {
            var result = client.GetData();
            Console.WriteLine(result);
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }
        Console.ReadLine();
    }
}