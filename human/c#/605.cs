csharp
using System;

class HttpCookies
{
    public bool HttpOnlyCookies { get; set; }
    public bool RequireSSL { get; set; }
}

class Program
{
    static void Main()
    {
        var httpCookies = new HttpCookies
        {
            HttpOnlyCookies = true,
            RequireSSL = true
        };

        Console.WriteLine($"httpCookies httpOnlyCookies=\"{httpCookies.HttpOnlyCookies}\" requireSSL=\"{httpCookies.RequireSSL}\"");
    }
}