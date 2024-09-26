csharp
using System;
using System.Text;
using System.Web.Security;

public class Program
{
    public static string encryptedCookie(string value)
    {
        var cookieText = Encoding.UTF8.GetBytes(value);
        var encryptedValue = Convert.ToBase64String(MachineKey.Protect(cookieText, "ProtectCookie"));
        return encryptedValue;
    }

    public static void Main()
    {
        string cookieValue = "Hello, World!";
        string encryptedValue = encryptedCookie(cookieValue);
        Console.WriteLine(encryptedValue);
    }
}