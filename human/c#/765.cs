csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static string GetEncryptedPassword(string password, string modulus, string exponent)
    {
        byte[] passwordBytes = Encoding.UTF8.GetBytes(password);

        // decode base64 string to be used as modulus(n) and exponent(e) components for
        // constructing the RSA public key object
        byte[] modulusBytes = Convert.FromBase64String(modulus);
        byte[] exponentBytes = Convert.FromBase64String(exponent);

        RSAParameters rsaParams = new RSAParameters();
        rsaParams.Modulus = modulusBytes;
        rsaParams.Exponent = exponentBytes;

        using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider())
        {
            rsa.ImportParameters(rsaParams);
            byte[] encryptedBytes = rsa.Encrypt(passwordBytes, false);
            // url encode the encrypted password
            string encrypted = Uri.EscapeDataString(Convert.ToBase64String(encryptedBytes));
            return encrypted;
        }
    }

    public static void Main()
    {
        string password = "your_password";
        string modulus = "your_modulus";
        string exponent = "your_exponent";
        string encryptedPassword = GetEncryptedPassword(password, modulus, exponent);
        Console.WriteLine(encryptedPassword);
    }
}