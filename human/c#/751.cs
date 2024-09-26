csharp
using System;
using System.Threading.Tasks;
using Microsoft.IdentityModel.Clients.ActiveDirectory;

public class Program
{
    public static async Task Main(string[] args)
    {
        var tenantId = "your_tenant_id";
        var appId = "your_app_id";
        var secretKey = "your_secret_key";

        var context = new AuthenticationContext("https://login.windows.net/" + tenantId);
        ClientCredential clientCredential = new ClientCredential(appId, secretKey);
        var tokenResponse = await context.AcquireTokenAsync("https://vault.azure.net", clientCredential);
        var accessToken = tokenResponse.AccessToken;
        Console.WriteLine(accessToken);
    }
}