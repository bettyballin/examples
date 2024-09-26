csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Xml.Serialization;

public class SomeConfig
{
    // Your configuration properties go here
    public string Property1 { get; set; }
    public string Property2 { get; set; }
}

public class Program
{
    public static Stream CreateStream(string inputFile, string password)
    {
        byte[] salt = new byte[32];
        new RNGCryptoServiceProvider().GetBytes(salt);
        var key = new Rfc2898DeriveBytes(password, salt, 100000);
        var aes = Aes.Create();
        aes.Key = key.GetBytes(aes.KeySize / 8);
        aes.IV = key.GetBytes(aes.BlockSize / 8);

        ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);

        using (FileStream fs = new FileStream(inputFile, FileMode.Open))
        {
            using (CryptoStream cs = new CryptoStream(fs, decryptor, CryptoStreamMode.Read))
            {
                return cs;
            }
        }
    }

    public static SomeConfig ReadEncryptedConfiguration(string inputFile, string password)
    {
        using (var stream = CreateStream(inputFile, password))
        {
            var ser = new XmlSerializer(typeof(SomeConfig));
            var config = (SomeConfig) ser.Deserialize(stream);
            return config;
        }
    }

    public static void Main(string[] args)
    {
        string inputFile = "path_to_your_file.xml";
        string password = "your_password";

        SomeConfig config = ReadEncryptedConfiguration(inputFile, password);
        Console.WriteLine(config.Property1);
        Console.WriteLine(config.Property2);
    }
}