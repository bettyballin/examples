csharp
using System;
using System.ServiceModel;

namespace YourNamespace
{
    class Program
    {
        static void Main(string[] args)
        {
            foo.bar requestObj = new foo.bar();

            // Fill in your request object
            requestObj.FirstName = "Someone";
            // etc.

            // Set up the authentication using the function you provided
            var glowsAuthData = PrepareGlowsAuth("expressRateBook");

            // foo.<object name>Client is automatically created, this is the generated
            //   proxy class for communicating with the intended web service
            foo.barClient client = new foo.barClient(new CustomBinding(glowsAuthData.Item2), glowsAuthData.Item1);
            client.ClientCredentials.UserName.UserName = glowsAuthData.Item3;
            client.ClientCredentials.UserName.Password = glowsAuthData.Item4;

            // Use the client to send the request object and populate the response object
            // foo.<object name>Response is automatically generated when VS generates 
            //   the code for "Connected Service". It also makes it the return type 
            //   for foo.barClient.barResponse(foo.bar);
            foo.barResponse responseObj = client.barResponse(requestObj);

            Console.WriteLine(responseObj.ToString());
        }

        static Tuple<string, Binding, string, string> PrepareGlowsAuth(string serviceName)
        {
            // Your implementation of PrepareGlowsAuth
            throw new NotImplementedException();
        }
    }
}