csharp
using Microsoft.IdentityModel.Tokens;
using System;
using System.Text;
using Microsoft.Extensions.Configuration;

public class Program
{
    private static IConfiguration _config;

    public static void Main(string[] args)
    {
        _config = new ConfigurationBuilder()
            .AddJsonFile("appsettings.json")
            .Build();

        var key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_config.GetSection("Appsettings:key").Value));
    }
}