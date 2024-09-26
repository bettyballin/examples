csharp
using System;
using System.Security;

public class Strings
{
    public delegate void ApiCall(string password);

    public static void DecryptSecureString(SecureString secureString, ApiCall callback)
    {
        string password = new NetworkCredential(string.Empty, secureString).Password;
        callback(password);
    }
}

class Program
{
    static void Main()
    {
        SecureString secureString = new SecureString();
        foreach (char c in "yourSecurePassword")
        {
            secureString.AppendChar(c);
        }
        secureString.MakeReadOnly();

        Strings.DecryptSecureString(secureString, (password) =>
        {
            Console.WriteLine(password);
            // Do your API call here
        });
    }
}