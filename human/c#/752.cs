csharp
using System;
using System.Threading.Tasks;
using Microsoft.IdentityModel.Clients.ActiveDirectory;

public class AzureAccessToken
{
    public static string EncryptSecret { get; set; }
    private static string appId = "Application ID";
    private static string secretKey = "Secret key";
    private static string tenantId = "TenantId";

    public static async Task<string> GetAccessToken(string azureTenantId, string azureAppId, string azureSecretKey)
    {
        tenantId = azureTenantId;
        appId = azureAppId;
        secretKey = azureSecretKey;

        var context = new AuthenticationContext("https://login.windows.net/" + tenantId);
        ClientCredential clientCredential = new ClientCredential(appId, secretKey);
        var tokenResponse = await context.AcquireTokenAsync("https://vault.azure.net", clientCredential);
        var accessToken = tokenResponse.AccessToken;
        return accessToken;
    }

    public static void Main(string[] args)
    {
        Console.WriteLine("Enter Azure Tenant ID:");
        string azureTenantId = Console.ReadLine();

        Console.WriteLine("Enter Azure Application ID:");
        string azureAppId = Console.ReadLine();

        Console.WriteLine("Enter Azure Secret Key:");
        string azureSecretKey = Console.ReadLine();

        GetAccessToken(azureTenantId, azureAppId, azureSecretKey).Wait();

        string accessToken = GetAccessToken(azureTenantId, azureAppId, azureSecretKey).Result;
        Console.WriteLine("Access Token: " + accessToken);

        Console.ReadKey();
    }
}