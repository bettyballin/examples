csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class CryptoStreamCreator
{
    public CryptoStream CreateStream(string inputFile, string password)
    {
        byte[] passwordBytes = Encoding.UTF8.GetBytes(password);
        byte[] salt = new byte[32];

        FileStream fsCrypt = new FileStream(inputFile, FileMode.Open);
        fsCrypt.Read(salt, 0, salt.Length);

        RijndaelManaged AES = new RijndaelManaged();
        AES.KeySize = 256;
        AES.BlockSize = 128;
        var key = new Rfc2898DeriveBytes(passwordBytes, salt, 50000);
        AES.Key = key.GetBytes(AES.KeySize / 8);
        AES.IV = key.GetBytes(AES.BlockSize / 8);
        AES.Padding = PaddingMode.PKCS7;
        AES.Mode = CipherMode.CFB;

        return new CryptoStream(fsCrypt, AES.CreateDecryptor(), CryptoStreamMode.Read, false);
    }
}

class Program
{
    static void Main()
    {
        string inputFile = "path_to_your_file";
        string password = "your_password";

        CryptoStreamCreator creator = new CryptoStreamCreator();
        using (CryptoStream stream = creator.CreateStream(inputFile, password))
        {
            using (StreamReader reader = new StreamReader(stream))
            {
                Console.WriteLine(reader.ReadToEnd());
            }
        }
    }
}