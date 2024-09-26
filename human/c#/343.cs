csharp
using System;
using System.Web.Security;
using WebMatrix.WebData;

public class PasswordReset
{
    public string Email { get; set; }
}

public class Program
{
    public static void Main()
    {
        var model = new PasswordReset { Email = "user@example.com" };
        var token = WebSecurity.GeneratePasswordResetToken(model.Email);
        Console.WriteLine(token);
    }
}