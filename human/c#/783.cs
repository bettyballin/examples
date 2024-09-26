csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string publicKey = "a383a2916281721498ff28226f851613bab6f89eb0536e9f237e158596d3b012e5707eba9f2a2963faca63fcb10f5de79caf246c1f587ee6e8f895fd848f2da5aba9d71af4dd8d06e99ff3729631626ed3f3202e56962957c0110a99d2b3893feb148291e09b54fe7df121751fb8bb589576542321b4f548be06b9845ebc6bbef1427741c00b632c05854146b597fdef5a89ace1556a769c5eaff8fc0589e7ad4adb2e2a929969c77f395b2f5a276a9389d1f43c061c9459a65b77bcd581c107aa8424223a0b44ee52582362cc96b90eea071a0dda5e9cb8fd5c9fd4ac86e177c07d79071788cb08231240dc1c9169af2629ecec31751069f0c7ccc1c1752303";
        string exponent = "010001";
        string toEncrypt = "Test123";

        byte[] encryptedData = Encrypt(toEncrypt, publicKey, exponent);
        string base64Encrypted = Convert.ToBase64String(encryptedData);
        Console.WriteLine(base64Encrypted);
    }

    static byte[] Encrypt(string data, string publicKey, string exponent)
    {
        using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider())
        {
            RSAParameters rsap = new RSAParameters
            {
                Modulus = HexStringToByteArray(publicKey),
                Exponent = HexStringToByteArray(exponent)
            };
            rsa.ImportParameters(rsap);
            return rsa.Encrypt(Encoding.UTF8.GetBytes(data), false);
        }
    }

    static byte[] HexStringToByteArray(string hex)
    {
        int numberChars = hex.Length;
        byte[] bytes = new byte[numberChars / 2];
        for (int i = 0; i < numberChars; i += 2)
        {
            bytes[i / 2] = Convert.ToByte(hex.Substring(i, 2), 16);
        }
        return bytes;
    }
}