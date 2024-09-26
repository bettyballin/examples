csharp
using System;
using System.Configuration;

class Program
{
    static void Main()
    {
        var clientCredentials = new System.ServiceModel.Description.ClientCredentials();
        clientCredentials.UserName.UserName = ConfigurationManager.AppSettings["username"];
        clientCredentials.UserName.Password = ConfigurationManager.AppSettings["password"];

        Console.WriteLine("Username: " + clientCredentials.UserName.UserName);
        Console.WriteLine("Password: " + clientCredentials.UserName.Password);
    }
}