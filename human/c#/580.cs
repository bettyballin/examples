csharp
using System;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

class Program
{
    static async Task Main()
    {
        var oAuth = new { AuthorizationServer = "https://example.com/oauth/token" };
        var authorizationBasic = Convert.ToBase64String(Encoding.ASCII.GetBytes("client_id:client_secret"));
        var request = new HttpRequestMessage(HttpMethod.Post, oAuth.AuthorizationServer)
        {
            Content = new StringContent($"username=John&password=Smith&grant_type=password&uid=b17ac911-4cf1-4a3e-84a9-beac7b9da157", Encoding.UTF8, "application/x-www-form-urlencoded")
        };
        request.Headers.Authorization = new System.Net.Http.Headers.AuthenticationHeaderValue("Basic", authorizationBasic);
        request.Headers.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
        var client = new HttpClient();
        var response = await client.SendAsync(request);
        Console.WriteLine(await response.Content.ReadAsStringAsync());
    }
}