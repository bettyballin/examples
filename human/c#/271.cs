csharp
using System;

public class SecurityChecker
{
    public string UserName { get; set; }
    public string Password { get; set; }

    public void CheckSecurity()
    {
        if ((this.UserName == null || this.Password == null) ||
            (this.UserName == "username" && this.Password == "password"))
        {
            throw new Exception("Unknown username or incorrect password.");
        }
    }

    public static void Main(string[] args)
    {
        SecurityChecker checker = new SecurityChecker();
        checker.UserName = "username";
        checker.Password = "password";

        try
        {
            checker.CheckSecurity();
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }
    }
}