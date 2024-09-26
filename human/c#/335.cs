csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    public static byte[] EncryptPart(ICryptoTransform crypt, byte[] toEncrypt)
    {
        try
        {
            MemoryStream mStream = new MemoryStream();
            CryptoStream cStream = new CryptoStream(mStream, crypt, CryptoStreamMode.Write);
            cStream.Write(toEncrypt, 0, toEncrypt.Length);
            cStream.FlushFinalBlock();
            byte[] ret = mStream.ToArray();
            cStream.Close();
            mStream.Close();

            Console.WriteLine("DES OUTPUT : " + ByteArrayToString(ret));
            return ret;
        }
        catch (CryptographicException e)
        {
            Console.WriteLine("A Cryptographic error occurred: {0}", e.Message);
            return null;
        }
    }

    public static string ByteArrayToString(byte[] ba)
    {
        StringBuilder sb = new StringBuilder(ba.Length * 2);
        foreach (byte b in ba)
        {
            sb.AppendFormat("{0:x2}", b);
        }
        return sb.ToString();
    }

    static void Main()
    {
        DESCryptoServiceProvider des = new DESCryptoServiceProvider();
        des.Key = Encoding.UTF8.GetBytes("01234567");
        des.IV = Encoding.UTF8.GetBytes("01234567");
        ICryptoTransform encryptor = des.CreateEncryptor(des.Key, des.IV);
        byte[] toEncrypt = Encoding.UTF8.GetBytes("Hello, World!");
        EncryptPart(encryptor, toEncrypt);
    }
}