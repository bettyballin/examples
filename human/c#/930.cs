csharp
using System;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.Identity.Client;

class Program
{
    static async Task Main(string[] args)
    {
        var app = ConfidentialClientApplicationBuilder.Create("your_client_id")
            .WithClientSecret("your_client_secret")
            .WithTenantId("your_tenant_id")
            .Build();

        var ResourceIds = new[] { "https://xxxx.azurewebsites.net/.default" };

        var token = await app.AcquireTokenForClient(ResourceIds).ExecuteAsync();
        var accesstoken = token.AccessToken;

        using (var client = new HttpClient())
        {
            client.DefaultRequestHeaders.Add("Authorization", "Bearer " + accesstoken);
            var requestURl = new Uri($"https://xxxx.azurewebsites.net/weatherforecast");
            var response = await client.GetAsync(requestURl);
            string result = await response.Content.ReadAsStringAsync();
            Console.WriteLine(result);
        }
    }
}