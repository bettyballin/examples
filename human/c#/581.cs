csharp
using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;

class Program
{
    static async Task Main(string[] args)
    {
        string oAuthAuthorizationServer = "https://your-oauth-server.com/token";
        string username = "John";
        string password = "Smith";
        string grantType = "password";
        string uid = "b17ac911-4cf1-4a3e-84a9-beac7b9da157";
        string authorizationBasic = "your-base64-encoded-credentials";

        var httpClient = new HttpClient();
        httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Basic", authorizationBasic);

        var request = new HttpRequestMessage(HttpMethod.Post, oAuthAuthorizationServer)
        {
            Content = new StringContent($"username={username}&password={password}&grant_type={grantType}&uid={uid}", Encoding.UTF8, "application/x-www-form-urlencoded")
        };

        request.Headers.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

        var response = await httpClient.SendAsync(request);

        if (response.IsSuccessStatusCode)
        {
            var responseData = await response.Content.ReadAsStringAsync();
            Console.WriteLine(responseData);
        }
        else
        {
            Console.WriteLine($"Error: {response.StatusCode}");
        }
    }
}