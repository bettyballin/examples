csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        string stringDataToEncrypt = "Hello, World!";
        string encryptedBase64String = EncryptData(stringDataToEncrypt);
        Console.WriteLine(encryptedBase64String);
    }

    public static string EncryptData(string stringDataToEncrypt)
    {
        using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider())
        {
            byte[] dataToEncrypt = Encoding.UTF8.GetBytes(stringDataToEncrypt);
            byte[] encryptedData = rsa.Encrypt(dataToEncrypt, true);
            return Convert.ToBase64String(encryptedData);
        }
    }
}