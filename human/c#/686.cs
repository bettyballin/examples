csharp
using Microsoft.AspNetCore.Authentication;

public class AwesomeAuthenticationOptions : AuthenticationOptions {
    public AwesomeAuthenticationOptions() {
        AuthenticationScheme = "AwesomeAuthentication";
        AutomaticAuthenticate = false;
    }
}

class Program
{
    static void Main(string[] args)
    {
        var options = new AwesomeAuthenticationOptions();
        System.Console.WriteLine(options.AuthenticationScheme);
        System.Console.WriteLine(options.AutomaticAuthenticate);
    }
}