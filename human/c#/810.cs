csharp
using System;

class Program
{
    static void Main()
    {
        var passwordVerifier = new PasswordVerifier();
        Console.WriteLine(passwordVerifier.VerifyPassword("storedPassword", "userPassword"));
        Console.WriteLine(passwordVerifier.VerifyPassword("storedPassword", ""));
        Console.WriteLine(passwordVerifier.VerifyPassword("storedPassword", null));
    }
}

public class PasswordVerifier
{
    public bool VerifyPassword(string storedPassword, string userPassword)
    {
        if(string.IsNullOrWhiteSpace(userPassword))
        {
            return false;
        }
        return storedPassword == userPassword;
    }
}