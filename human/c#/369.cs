csharp
using System;
using System.Net;

class Program
{
    static void Main()
    {
        string srQueryRequest = "http://example.com"; // replace with your URL
        WebProxy proxy = new WebProxy("http://proxy.example.com:8080"); // replace with your proxy

        using (WebClient webClient = new WebClient())
        {
            webClient.Proxy = proxy;
            var srResult = webClient.DownloadString(srQueryRequest);
            Console.WriteLine(srResult);
        }
    }
}