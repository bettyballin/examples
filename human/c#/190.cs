csharp
using System;
using System.Net;
using System.Net.CredentialsCache;

class Program
{
    static void Main()
    {
        // Replace with your web service URL
        string serviceUrl = "http://example.com/service";

        // Replace with your username, password, and domain name
        string username = "username";
        string password = "password";
        string domainname = "domainname";

        CredentialCache cache = new CredentialCache();
        cache.Add(new Uri(serviceUrl), "Negotiate", new NetworkCredential(username, password, domainname));

        // Assuming 'service' is a web service proxy object
        // Replace with your actual web service proxy object
        var service = new YourWebServiceProxy();
        service.Credentials = cache;
    }
}