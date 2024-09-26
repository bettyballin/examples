csharp
using System;
using System.Web.Helpers;

public class Program
{
    private string savedHashedPassword;

    public void SavePassword(string unhashedPassword)
    {
        string hashedPassword = Crypto.HashPassword(unhashedPassword);
        savedHashedPassword = hashedPassword;
    }

    public bool CheckPassword(string unhashedPassword)
    {
        return Crypto.VerifyHashedPassword(savedHashedPassword, unhashedPassword);
    }

    public static void Main()
    {
        Program program = new Program();
        program.SavePassword("mysecretpassword");
        Console.WriteLine(program.CheckPassword("mysecretpassword"));  // True
        Console.WriteLine(program.CheckPassword("wrongpassword"));  // False
    }
}