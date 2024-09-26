csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Configuration;

public class Program
{
    public static string Encrypt(string toEncrypt, bool useHashing)
    {
        byte[] keyArray;
        byte[] toEncryptArray = UTF8Encoding.UTF8.GetBytes(toEncrypt);

        string key = ConfigurationManager.AppSettings["SecurityKey"];

        if (useHashing)
        {
            MD5CryptoServiceProvider hashmd5 = new MD5CryptoServiceProvider();
            keyArray = hashmd5.ComputeHash(UTF8Encoding.UTF8.GetBytes(key));
            hashmd5.Clear();
        }
        else
            keyArray = UTF8Encoding.UTF8.GetBytes(key);

        TripleDESCryptoServiceProvider tdes = new TripleDESCryptoServiceProvider();
        tdes.Key = keyArray;
        tdes.Mode = CipherMode.ECB;
        tdes.Padding = PaddingMode.PKCS7;

        ICryptoTransform cTransform = tdes.CreateEncryptor();
        byte[] resultArray = cTransform.TransformFinalBlock(toEncryptArray, 0, toEncryptArray.Length);
        tdes.Clear();
        return Convert.ToBase64String(resultArray, 0, resultArray.Length);
    }

    public static void Main()
    {
        string encrypted = Encrypt("Hello, World!", true);
        Console.WriteLine(encrypted);
    }
}

xml
<?xml version="1.0" encoding="utf-8"?>
<configuration>
  <appSettings>
    <add key="SecurityKey" value="your_secret_key_here"/>
  </appSettings>
</configuration>