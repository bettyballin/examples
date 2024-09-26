csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        var encryptedData = Convert.FromBase64String("avgPDxTwl9Nbr7FUnTgKvXXQ1Rrl2q2R0jBgsrn1F9i5GEyGg/vaw3i3Vkg1zUz3Wby/juz2yXE6ZpU=");
        var salt = Convert.FromBase64String("MDEyMzQ1Njc4OTAx");
        var password = "my password";
        var plaintext = Decrypt(encryptedData, salt, password);
        Console.WriteLine(Encoding.UTF8.GetString(plaintext)); // The quick brown fox jumps over the lazy dog
    }

    public static byte[] Decrypt(byte[] encryptedData, byte[] salt, string password)
    {
        var ciphertext = encryptedData[0..^16];
        var tag = encryptedData[^16..];
        using Rfc2898DeriveBytes pbkdf2 = new Rfc2898DeriveBytes(Encoding.UTF8.GetBytes(password), salt, 100000, HashAlgorithmName.SHA256);
        using var aes = new AesGcm(pbkdf2.GetBytes(32));
        var plaintext = new byte[ciphertext.Length];
        aes.Decrypt(salt, ciphertext, tag, plaintext);
        return plaintext;
    }
}