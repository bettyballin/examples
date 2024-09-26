csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        var password = "mysecretpassword";
        var actualPassword = "mysecretpassword";

        byte[] passwordTryHashBytes;
        using (var sha256 = SHA256.Create())
        {
            passwordTryHashBytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(password));
        }

        byte[] actualPasswordBytes;
        using (var sha256 = SHA256.Create())
        {
            actualPasswordBytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(actualPassword));
        }

        Console.WriteLine(passwordTryHashBytes.SequenceEqual(actualPasswordBytes));
    }
}