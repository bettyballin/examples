csharp
using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;

class Program
{
    static async Task Main(string[] args)
    {
        var handler = new HttpClientHandler();
        handler.Credentials = new System.Net.NetworkCredential("user", "pass");

        var client = new HttpClient(handler);

        // Make the initial authentication request
        await client.GetAsync("https://omg.wtf/user");

        // All subsequent requests will include any cookies set in the initial response
        var response = await client.GetAsync("http://omg.wtf/911");

        Console.WriteLine(await response.Content.ReadAsStringAsync());
    }
}