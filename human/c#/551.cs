csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    private const string KEY = "Chiave";

    static void Main(string[] args)
    {
        string plainText = "Data to be encrypted";

        byte[] keyArray;
        using (MD5CryptoServiceProvider hashmd5 = new MD5CryptoServiceProvider())
        {
            keyArray = hashmd5.ComputeHash(UTF8Encoding.UTF8.GetBytes(KEY));
        }

        byte[] toEncryptArray = UTF8Encoding.UTF8.GetBytes(plainText);

        using (TripleDESCryptoServiceProvider tdes = new TripleDESCryptoServiceProvider())
        {
            tdes.Key = keyArray;
            tdes.Mode = CipherMode.CBC;
            tdes.Padding = PaddingMode.PKCS7;

            ICryptoTransform cTransform = tdes.CreateEncryptor();
            byte[] encArray = cTransform.TransformFinalBlock(toEncryptArray, 0, toEncryptArray.Length);

            cTransform = tdes.CreateDecryptor();
            byte[] decArray = cTransform.TransformFinalBlock(encArray, 0, encArray.Length);

            string result = UTF8Encoding.UTF8.GetString(decArray);
            Console.WriteLine(result);
        }

        Console.ReadLine();
    }
}