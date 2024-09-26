csharp
using Microsoft.Extensions.Configuration;

public class UserAuth
{
    private readonly IConfiguration _config;

    public UserAuth(IConfiguration config)
    {
        _config = config;
    }

    public static void Main(string[] args)
    {
        var builder = new ConfigurationBuilder();
        var config = builder.Build();
        var userAuth = new UserAuth(config);
    }
}