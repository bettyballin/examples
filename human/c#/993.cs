csharp
using System;
using System.Text;
using System.Web.Security;

public class CookieDecryptor
{
    public string DecryptedCookie(string value)
    {
        var bytes = Convert.FromBase64String(value);
        var output = MachineKey.Unprotect(bytes, "ProtectCookie");
        string result = Encoding.UTF8.GetString(output);
        return result;
    }

    public static void Main()
    {
        var decryptor = new CookieDecryptor();
        Console.Write("Enter the cookie value to decrypt: ");
        var value = Console.ReadLine();
        var decryptedValue = decryptor.DecryptedCookie(value);
        Console.WriteLine("Decrypted value: " + decryptedValue);
    }
}