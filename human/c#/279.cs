csharp
using System;

public class User
{
    public string ResetPassword()
    {
        // Your password reset logic here
        return "TEMPORARYPASSWORD";
    }

    public void ChangePassword(string oldPassword, string newPassword)
    {
        // Your password change logic here
        Console.WriteLine("Password changed successfully.");
    }
}

class Program
{
    static void Main()
    {
        User user = new User();
        string newPassword = user.ResetPassword();
        user.ChangePassword(newPassword, "SOMENEWPASSWORD");
    }
}