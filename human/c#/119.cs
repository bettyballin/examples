csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class RSAEncryption
{
    #region "RSA Encrypt/Decrypt"

    public static string RSAEncrypt(string str, string publicKey)
    {
        try
        {
            RSACryptoServiceProvider RSA = new RSACryptoServiceProvider();
            RSA.FromXmlString(publicKey);
            byte[] EncryptedStr = null;

            EncryptedStr = RSA.Encrypt(Encoding.ASCII.GetBytes(str), false);

            int i = 0;
            StringBuilder s = new StringBuilder();
            for (i = 0; i < EncryptedStr.Length; i++)
            {
                if (i != EncryptedStr.Length - 1)
                {
                    s.Append(EncryptedStr[i] + " ");
                }
                else
                {
                    s.Append(EncryptedStr[i]);
                }
            }

            return s.ToString();
        }
        catch (Exception err)
        {
            Console.WriteLine(err.ToString());
            return null;
        }
    }

    public static string RSADecrypt(string str, string privateKey)
    {
        try
        {
            RSACryptoServiceProvider RSA = new RSACryptoServiceProvider();
            RSA.FromXmlString(privateKey);

            byte[] DecryptedStr = RSA.Decrypt(HexToByteArr(str), false);

            StringBuilder s = new StringBuilder();
            int i = 0;
            for (i = 0; i < DecryptedStr.Length; i++)
            {
                s.Append(Convert.ToChar(DecryptedStr[i]));
            }

            return s.ToString();
        }
        catch (Exception err)
        {
            Console.WriteLine(err.ToString());
            return null;
        }
    }

    public static byte[] HexToByteArr(string str)
    {
        string[] byteStrings = str.Split(' ');
        byte[] bytes = new byte[byteStrings.Length];

        for (int i = 0; i < byteStrings.Length; i++)
        {
            bytes[i] = Convert.ToByte(byteStrings[i]);
        }

        return bytes;
    }

    #endregion

    public static void Main()
    {
        string publicKey = "<your public key>";
        string privateKey = "<your private key>";
        string originalString = "Hello, World!";

        string encryptedString = RSAEncrypt(originalString, publicKey);
        Console.WriteLine("Encrypted String: " + encryptedString);

        string decryptedString = RSADecrypt(encryptedString, privateKey);
        Console.WriteLine("Decrypted String: " + decryptedString);
    }
}