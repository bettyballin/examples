Here is the C# code:
csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static string DecryptStr(string text)
    {
        try
        {
            if (text == null)
                return null;

            string encryptionKey = "****";
            byte[] salt = new byte[] { 0x49, 0x76, 0x61, 0x6e, 0x20, 0x4d, 0x65, 0x64, 0x76, 0x65, 0x64, 0x65, 0x76 };

            using (var deriveBytes = new Rfc2898DeriveBytes(encryptionKey, salt, 100000))
            {
                byte[] key = deriveBytes.GetBytes(32);
                byte[] iv = deriveBytes.GetBytes(16);

                byte[] cipherBytes = Convert.FromBase64String(text);
                using (var aes = Aes.Create())
                {
                    aes.Key = key;
                    aes.IV = iv;
                    aes.Mode = CipherMode.CBC;
                    aes.Padding = PaddingMode.None;

                    using (var decryptor = aes.CreateDecryptor(aes.Key, aes.IV))
                    {
                        using (var ms = new MemoryStream(cipherBytes))
                        {
                            using (var cs = new CryptoStream(ms, decryptor, CryptoStreamMode.Read))
                            {
                                using (var sr = new StreamReader(cs))
                                {
                                    return sr.ReadToEnd();
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
            return null;
        }
    }

    public static void Main()
    {
        string decryptedText = DecryptStr("your_base64_encoded_text_here");
        Console.WriteLine(decryptedText);
    }
}