csharp
using System;
using System.ServiceModel;

class Program
{
    static void Main()
    {
        var serviceClient = new YourServiceClient(); // replace with your service client
        serviceClient.ClientCredentials.UserName.UserName = "username";
        serviceClient.ClientCredentials.UserName.Password = "password";
        serviceClient.Open();
        // call service methods here
        serviceClient.Close();
    }
}