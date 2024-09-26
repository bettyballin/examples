csharp
using System;
using System.Net;

class Program
{
    static void Main()
    {
        var service = new WebClient();
        service.Credentials = System.Net.CredentialCache.DefaultCredentials;
        Console.WriteLine("Default credentials set.");
    }
}