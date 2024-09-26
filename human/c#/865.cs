csharp
using System;

class Program
{
    static void Main()
    {
        // Assuming client is an instance of a WCF client
        var client = new YourServiceClient();

        string runAs = "YourUsername";
        string runAsPassword = "YourPassword";
        string runAsDomain = "YourDomain";

        client.ClientCredentials.Windows.ClientCredential.UserName = runAs;
        client.ClientCredentials.Windows.ClientCredential.Password = runAsPassword;
        client.ClientCredentials.Windows.ClientCredential.Domain = runAsDomain;
    }
}