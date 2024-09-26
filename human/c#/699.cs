csharp
using System;
using System.Net.Http;
using System.Threading.Tasks;

class Program
{
    static async Task Main(string[] args)
    {
        using var client = new HttpClient();
        var response = await client.GetAsync("http://localhost:5000/api/token?username=cuong&password=1");
        Console.WriteLine(response.StatusCode);
    }
}