csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        // Set your password and salt
        string password = "your_password";
        byte[] salt = Encoding.UTF8.GetBytes("your_salt");

        // Derive bytes
        Rfc2898DeriveBytes deriveBytes = new Rfc2898DeriveBytes(password, salt, 100000);

        // Create AES object
        Aes aes = Aes.Create();

        // Set key size to 128 bits (16 bytes)
        aes.Key = deriveBytes.GetBytes(16);

        // Set other AES properties
        aes.IV = deriveBytes.GetBytes(16);
        aes.Mode = CipherMode.CBC;
        aes.Padding = PaddingMode.PKCS7;

        // Create encryptor
        ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);

        // Your code here...
    }
}