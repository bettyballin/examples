csharp
using System;
using System.Net;

class Program
{
    static void Main(string[] args)
    {
        var client = new WebClient();
        client.Credentials = CredentialCache.DefaultNetworkCredentials;
        // Use the client to make a request
        client.DownloadString("http://example.com");
    }
}