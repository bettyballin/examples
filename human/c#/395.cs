csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class ConfigHelper
{
    public static string PassPhrase = "your_passphrase";
    public static string SaltValue = "your_salt_value";
    public static string HashAlgorithm = "SHA1";
    public static int PasswordIterations = 2;
    public static string InitVector = "your_init_vector";
    public static int KeySize = 256;
}

public class EncryptionHelper
{
    public static string EncryptData(string encryptText, string passPhrase, string saltValue, string hashAlgorithm, int passwordIterations, string initVector, int keySize)
    {
        var bytes = Encoding.ASCII.GetBytes(encryptText);
        var rgbSalt = Encoding.ASCII.GetBytes(saltValue);
        var rgbIV = Encoding.ASCII.GetBytes(initVector);

        var deriveBytes = new Rfc2898DeriveBytes(passPhrase, rgbSalt, passwordIterations);
        var rgbKey = deriveBytes.GetBytes(keySize / 8);

        var managed = new RijndaelManaged { Mode = CipherMode.CBC };
        var crypto = managed.CreateEncryptor(rgbKey, rgbIV);

        using (var ms = new MemoryStream())
        {
            using (var cs = new CryptoStream(ms, crypto, CryptoStreamMode.Write))
            {
                cs.Write(bytes, 0, bytes.Length);
            }
            return Convert.ToBase64String(ms.ToArray());
        }
    }

    public static string DecryptData(string decryptText, string passPhrase, string saltValue, string hashAlgorithm, int passwordIterations, string initVector, int keySize)
    {
        var bytes = Convert.FromBase64String(decryptText);
        var rgbSalt = Encoding.ASCII.GetBytes(saltValue);
        var rgbIV = Encoding.ASCII.GetBytes(initVector);

        var deriveBytes = new Rfc2898DeriveBytes(passPhrase, rgbSalt, passwordIterations);
        var rgbKey = deriveBytes.GetBytes(keySize / 8);

        var managed = new RijndaelManaged { Mode = CipherMode.CBC };
        var crypto = managed.CreateDecryptor(rgbKey, rgbIV);

        using (var ms = new MemoryStream(bytes))
        {
            using (var cs = new CryptoStream(ms, crypto, CryptoStreamMode.Read))
            {
                using (var reader = new StreamReader(cs))
                {
                    return reader.ReadToEnd();
                }
            }
        }
    }
}

public class Program
{
    public static string EncryptData(string encryptText)
    {
        return EncryptionHelper.EncryptData(encryptText, ConfigHelper.PassPhrase, ConfigHelper.SaltValue, ConfigHelper.HashAlgorithm, ConfigHelper.PasswordIterations, ConfigHelper.InitVector, ConfigHelper.KeySize);
    }

    public static string DecryptData(string decryptText)
    {
        return EncryptionHelper.DecryptData(decryptText, ConfigHelper.PassPhrase, ConfigHelper.SaltValue, ConfigHelper.HashAlgorithm, ConfigHelper.PasswordIterations, ConfigHelper.InitVector, ConfigHelper.KeySize);
    }

    public static void Main()
    {
        var encrypted = EncryptData("Hello, World!");
        Console.WriteLine($"Encrypted: {encrypted}");

        var decrypted = DecryptData(encrypted);
        Console.WriteLine($"Decrypted: {decrypted}");
    }
}